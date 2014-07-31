/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.archivo.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.SIGAMessage;
import pe.com.microdata.cjava.common.validador.Validador;
import pe.com.microdata.cjava.dataaccess.domain.archivo.ArchivoDAO;
import pe.com.microdata.cjava.dataaccess.model.archivo.ArchivoVO;
import pe.com.microdata.cjava.service.archivo.GestionarArchivo;
import pe.com.microdata.cjava.service.archivo.dto.ArchivoDTO;


@Service("gestionarArchivo")
public class GestionarArchivoImpl implements GestionarArchivo {

    DateFormat format = new SimpleDateFormat(Constants.FORMATO_FECHA_HORA);
    @Autowired
    ArchivoDAO archivoDAO;

    @Override
    public SIGAMessage cargarArchivo(ArchivoDTO archivoDTO) {

        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        message.setMessageType(SIGAMessage.MessageType.ERROR);
        ArchivoVO archivoVO = new ArchivoVO();
        Calendar c = Calendar.getInstance();
        Integer idArchivo = 0;
        try {

            File archivoInput = new File(archivoDTO.getRutaServidor() + "images/" + archivoDTO.getArchivo().getOriginalFilename());
            byte[] archivo = FileUtils.readFileToByteArray(archivoInput);
            String extension = FilenameUtils.getExtension(archivoDTO.getArchivo().getOriginalFilename());
            String fileName = FilenameUtils.removeExtension(archivoInput.getName());
            archivoVO.setArchivo(archivo);
            archivoVO.setExtension(extension);
            archivoVO.setNomArchivo(fileName);
            if (Validador.noNuloNoVacio(archivoDTO.getRutaArchivo())) {
                archivoVO.setRuta(archivoDTO.getRutaArchivo());
            } else {
                archivoVO.setRuta(fileName);
            }
            archivoVO.setFecCreacion(c.getTime());
            idArchivo = archivoDAO.insert(archivoVO);
            message.setMessageType(SIGAMessage.MessageType.SUCCESS);
            message.setSuccess(Boolean.TRUE);
            message.addMessages("Archivo Guardado");
        } catch (Exception e) {
            message.addMessages("Error al subir Archivo");
//            message.addMessages(e.getLocalizedMessage());

        }
        return message;
    }

    @Override
    public ArchivoDTO obtenerArchivoEnRutaPorId(Integer idArchivo, String ruta) {
        ArchivoDTO archivoDTO = new ArchivoDTO();
        ArchivoVO archivoVO = archivoDAO.get(idArchivo);
        ByteArrayOutputStream baos;
        try {
            baos = new ByteArrayOutputStream();
            byte[] b = archivoVO.getArchivo();
            baos.write(b);
            archivoDTO.setArchivoOutput(baos);
            archivoDTO.setNomArchivo(archivoVO.getNomArchivo());
            archivoDTO.setRutaArchivo(archivoVO.getRuta());
            archivoDTO.setExtension(archivoVO.getExtension());
            archivoDTO.setFecCreacion(format.format(archivoVO.getFecCreacion()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return archivoDTO;

    }

    @Override
    public List obtenerArchivos() {
        List<ArchivoVO> archivoVOs = archivoDAO.obtenerArchivos();
        List<ArchivoDTO> archivoDTOs = new ArrayList<ArchivoDTO>();
        ArchivoDTO archivoDTO = new ArchivoDTO();
        for (ArchivoVO archivoVO : archivoVOs) {
            archivoDTO = new ArchivoDTO();
            archivoDTO.setIdArchivo(archivoVO.getIdArchivo());
            archivoDTO.setNomArchivo(archivoVO.getNomArchivo());
            archivoDTO.setRutaArchivo(archivoVO.getRuta());
            archivoDTO.setExtension(archivoVO.getExtension());
            archivoDTO.setFecCreacion(format.format(archivoVO.getFecCreacion()));
            archivoDTOs.add(archivoDTO);
        }
        return archivoDTOs;

    }

    @Override
    public SIGAMessage eliminarArchivo(Integer idArchivo) {
        SIGAMessage message = new SIGAMessage();
        message.setSuccess(Boolean.FALSE);
        message.setMessageType(SIGAMessage.MessageType.ERROR);
        try {
            ArchivoVO archivoVO = archivoDAO.get(idArchivo);
            if (archivoVO != null) {
                archivoDAO.delete(archivoVO);
                message.setSuccess(Boolean.TRUE);
                message.setMessageType(SIGAMessage.MessageType.SUCCESS);
                message.addMessages("Archivo Eliminado");
            }

        } catch (Exception e) {
            message.addMessages("Error al eliminae Archivo");
            e.printStackTrace();
        }
        return message;
    }
}
