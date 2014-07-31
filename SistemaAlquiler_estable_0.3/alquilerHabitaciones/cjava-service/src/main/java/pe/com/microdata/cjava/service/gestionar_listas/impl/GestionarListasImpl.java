/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.gestionar_listas.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.Constants;
import pe.com.microdata.cjava.common.base.ItemDTO;
import pe.com.microdata.cjava.common.base.ItemUbigeoDTO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.SubtipoDAO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.SubTipoVO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
import pe.com.microdata.cjava.service.gestionar_listas.GestionarListas;
import pe.com.microdata.cjava.service.gestionar_listas.dto.OptionDTO;

/**
 *
 * @author meliMeli
 */
@Service("gestionarListas")
public class GestionarListasImpl implements GestionarListas {

    @Autowired
    private SubtipoDAO subTipoDAO;
    @Autowired
    private UbigeoDAO ubigeoDAO;
    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMATO_FECHA);
    SimpleDateFormat formatHora = new SimpleDateFormat(Constants.FORMATO_FECHA_HORA);

    @Override
    public List obtenerSubTiposPorTipo(Integer idTipo) {
        return subTipoDAO.getSubTiposPorTipo(idTipo);
    }

    @Override
    public String obtenerMes(Integer mes) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "Enero");
        hashMap.put(2, "Febrero");
        hashMap.put(3, "Marzo");
        hashMap.put(4, "Abril");
        hashMap.put(5, "Mayo");
        hashMap.put(6, "Junio");
        hashMap.put(7, "Julio");
        hashMap.put(8, "Agosto");
        hashMap.put(9, "Setiembre");
        hashMap.put(10, "Octubre");
        hashMap.put(11, "Noviembre");
        hashMap.put(12, "Diciembre");
        return hashMap.get(mes).toString();
    }

    @Override
    public List obtenerMeses() {

        List meses = new ArrayList<ItemDTO>();
        meses.add(new ItemDTO(Calendar.JANUARY, "Enero"));
        meses.add(new ItemDTO(Calendar.FEBRUARY, "Febrero"));
        meses.add(new ItemDTO(Calendar.MARCH, "Marzo"));
        meses.add(new ItemDTO(Calendar.APRIL, "Abril"));
        meses.add(new ItemDTO(Calendar.MAY, "Mayo"));
        meses.add(new ItemDTO(Calendar.JUNE, "Junio"));
        meses.add(new ItemDTO(Calendar.JULY, "Julio"));
        meses.add(new ItemDTO(Calendar.AUGUST, "Agosto"));
        meses.add(new ItemDTO(Calendar.SEPTEMBER, "Septiembre"));
        meses.add(new ItemDTO(Calendar.OCTOBER, "Octubre"));
        meses.add(new ItemDTO(Calendar.NOVEMBER, "Noviembre"));
        meses.add(new ItemDTO(Calendar.DECEMBER, "Diciembre"));
        return meses;

    }

    @Override
    public List obtenerAnhos() {
        List anhos = new ArrayList<OptionDTO>();
        Calendar calendar = Calendar.getInstance();
        int anho = calendar.get(Calendar.YEAR);
        for (int a = anho - Constants.ANHO_OFFSET_MINUS; a < anho + Constants.ANHO_OFFSET_PLUS; a++) {
            anhos.add(new OptionDTO(a, String.valueOf(a)));
        }
        return anhos;
    }

    @Override
    public String obtenerDesSubtipoPorId(Integer idSubTipo) {
        SubTipoVO doc = subTipoDAO.obtenerSubtipoPorId(idSubTipo);
        return doc.getNomSubtipo();
    }

    @Override
    public List obtenerSubTiposPorTipoInicioZero(Integer idTipo) {
        List<SubTipoVO> subtipoVOs = new ArrayList<SubTipoVO>();
        SubTipoVO subTipoZero = new SubTipoVO(0);
        subTipoZero.setNomSubtipo("");
        subtipoVOs.add(subTipoZero);
        subtipoVOs.addAll(subTipoDAO.getSubTiposPorTipo(idTipo));
        return subtipoVOs;
    }

    ///////////////////////////UBIGEO///////////////////////////////////////////
    @Override
    public List obtenerPaises() {
        List<UbigeoVO> ubigeoVOs = ubigeoDAO.obtenerPaises();
        List<ItemUbigeoDTO> itemDTOs = new ArrayList<ItemUbigeoDTO>();
        ItemUbigeoDTO itemUbigeoDTO = new ItemUbigeoDTO();
        for (UbigeoVO ubigeoVO : ubigeoVOs) {
            itemUbigeoDTO = new ItemUbigeoDTO();
            itemUbigeoDTO.setCodigo(ubigeoVO.getIdPais());
            itemUbigeoDTO.setNombre(ubigeoVO.getNombreUbigeo());
            itemDTOs.add(itemUbigeoDTO);
        }
        return itemDTOs;
    }

    @Override
    public List<ItemUbigeoDTO> obtenerDepartamentosPorPais(String codPais) {
        List<UbigeoVO> ubigeoVOs = ubigeoDAO.obtenerDepartamentosPorPais(codPais);
        List<ItemUbigeoDTO> itemDTOs = new ArrayList<ItemUbigeoDTO>();
        ItemUbigeoDTO itemUbigeoDTO = new ItemUbigeoDTO();
        for (UbigeoVO ubigeoVO : ubigeoVOs) {
            itemUbigeoDTO = new ItemUbigeoDTO();
            itemUbigeoDTO.setCodigo(ubigeoVO.getIdDepartamento());
            itemUbigeoDTO.setNombre(ubigeoVO.getNombreUbigeo());
            itemDTOs.add(itemUbigeoDTO);
        }
        return itemDTOs;
    }

    @Override
    public List<ItemUbigeoDTO> obtenerProvinciaPorDepartamento(String codPais, String codDepartamento) {
        List<UbigeoVO> ubigeoVOs = ubigeoDAO.obtenerProvinciasPorDepartamento(codPais,codDepartamento);
        List<ItemUbigeoDTO> itemDTOs = new ArrayList<ItemUbigeoDTO>();
        ItemUbigeoDTO itemUbigeoDTO = new ItemUbigeoDTO();
        for (UbigeoVO ubigeoVO : ubigeoVOs) {
            itemUbigeoDTO = new ItemUbigeoDTO();
            itemUbigeoDTO.setCodigo(ubigeoVO.getIdProvincia());
            itemUbigeoDTO.setNombre(ubigeoVO.getNombreUbigeo());
            itemDTOs.add(itemUbigeoDTO);
        }
        return itemDTOs;
    }

    @Override
    public List<ItemUbigeoDTO> obtenerDistritoPorProvincia(String codPais, String codDepartamento, String codProvincia) {
        List<UbigeoVO> ubigeoVOs = ubigeoDAO.obtenerDistritoPorProvincia(codPais,codDepartamento,codProvincia);
        List<ItemUbigeoDTO> itemDTOs = new ArrayList<ItemUbigeoDTO>();
        ItemUbigeoDTO itemUbigeoDTO = new ItemUbigeoDTO();
        for (UbigeoVO ubigeoVO : ubigeoVOs) {
            itemUbigeoDTO = new ItemUbigeoDTO();
            itemUbigeoDTO.setCodigo(ubigeoVO.getIdDistrito());
            itemUbigeoDTO.setNombre(ubigeoVO.getNombreUbigeo());
            itemDTOs.add(itemUbigeoDTO);
        }
        return itemDTOs;
    }
    
    
    
}
