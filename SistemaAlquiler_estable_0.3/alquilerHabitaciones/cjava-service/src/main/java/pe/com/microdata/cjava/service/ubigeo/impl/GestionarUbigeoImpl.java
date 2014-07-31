/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.service.ubigeo.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microdata.cjava.common.base.ComboItemDTO;
import pe.com.microdata.cjava.dataaccess.domain.administracion.persona.UbigeoDAO;
import pe.com.microdata.cjava.dataaccess.model.administracion.persona.UbigeoVO;
//import pe.com.microdata.cjava.dataaccess.model.procedimiento.ItemUbigeoVO;
//import pe.com.microdata.cjava.dataaccess.model.procedimiento.WrapperVO;
import pe.com.microdata.cjava.service.ubigeo.GestionarUbigeo;

/**
 *
 * @author Alejandra Gonzales
 */
@Service("gestionarUbigeo")
public class GestionarUbigeoImpl implements GestionarUbigeo {
/*
    @Autowired
    SPUbigeoDAO ubigeoDAO;

    @Override
    public List obtenerDepartamentos() {
        List<ComboItemDTO> itemDTOs = new ArrayList<ComboItemDTO>();
        ComboItemDTO itemDTO = null;
        WrapperVO wrapperVO = ubigeoDAO.obtenerDepartamentos();
        for (Object object : wrapperVO.getResultados()) {
            ItemUbigeoVO itemUbigeoVO = (ItemUbigeoVO) object;
            itemDTO = new ComboItemDTO();
            itemDTO.setId(itemUbigeoVO.getCodigo());
            itemDTO.setNombre(itemUbigeoVO.getNombre().trim());
            itemDTOs.add(itemDTO);
        }
        return itemDTOs;
    }

    @Override
    public List obtenerProvincia(String codProvincia) {

        List<ComboItemDTO> itemDTOs = new ArrayList<ComboItemDTO>();
        if (!"0".equals(codProvincia)) {
            ComboItemDTO itemDTO = null;
            WrapperVO wrapperVO = ubigeoDAO.obtenerProvincias(codProvincia);
            for (Object object : wrapperVO.getResultados()) {
                ItemUbigeoVO itemUbigeoVO = (ItemUbigeoVO) object;
                itemDTO = new ComboItemDTO();
                itemDTO.setId(itemUbigeoVO.getCodigo());
                itemDTO.setNombre(itemUbigeoVO.getNombre().trim());
                itemDTOs.add(itemDTO);
            }
        }

        return itemDTOs;
    }

    @Override
    public List obtenerDistrito(String codDistrito) {
        List<ComboItemDTO> itemDTOs = new ArrayList<ComboItemDTO>();
        if (!"0".equals(codDistrito)) {
            ComboItemDTO itemDTO = null;
            WrapperVO wrapperVO = ubigeoDAO.obtenerDistritos(codDistrito);
            for (Object object : wrapperVO.getResultados()) {
                ItemUbigeoVO itemUbigeoVO = (ItemUbigeoVO) object;
                itemDTO = new ComboItemDTO();
                itemDTO.setId(itemUbigeoVO.getCodigo());
                itemDTO.setNombre(itemUbigeoVO.getNombre().trim());
                itemDTOs.add(itemDTO);
            }
        }
        return itemDTOs;
    }


    @Override
    public String obtenerNombreDepartamento(String codDepartamento) {
        List<ComboItemDTO> itemDTOs = obtenerDepartamentos();
        for(ComboItemDTO combo:itemDTOs){
            if (combo.getId().equals(codDepartamento)) {
                return combo.getNombre();
            }
        }
        return "";
    }

    @Override
    public String obtenerNombreProvincia(String codProvincia,String codDepart) {
        List<ComboItemDTO> itemDTOs = obtenerProvincia(codDepart);
        for(ComboItemDTO combo:itemDTOs){
            if (combo.getId().equals(codProvincia)) {
                return combo.getNombre();
            }
        }
        return "";

    }

    
    @Override
    public String obtenerNombreDistrito(String codDistrito, String codProvincia) {
        List<ComboItemDTO> itemDTOs = obtenerDistrito(codProvincia);
        for(ComboItemDTO combo:itemDTOs){
            if (combo.getId().equals(codDistrito)) {
                return combo.getNombre();
            }
        }
        return "";
    }

    @Override
    public List obtenerProvincias() {
        List<ComboItemDTO> itemDTOs = new ArrayList<ComboItemDTO>();        
            ComboItemDTO itemDTO = null;
            WrapperVO wrapperVO = ubigeoDAO.obtenerProvincias();
            for (Object object : wrapperVO.getResultados()) {
                ItemUbigeoVO itemUbigeoVO = (ItemUbigeoVO) object;
                itemDTO = new ComboItemDTO();
                itemDTO.setId(itemUbigeoVO.getCodigo());
                itemDTO.setNombre(itemUbigeoVO.getNombre().trim());
                itemDTOs.add(itemDTO);
            
        }

        return itemDTOs;        
    }

    @Override
    public List obtenerDistritos() {
        List<ComboItemDTO> itemDTOs = new ArrayList<ComboItemDTO>();        
            ComboItemDTO itemDTO = null;
            WrapperVO wrapperVO = ubigeoDAO.obtenerDistritos();
            for (Object object : wrapperVO.getResultados()) {
                ItemUbigeoVO itemUbigeoVO = (ItemUbigeoVO) object;
                itemDTO = new ComboItemDTO();
                itemDTO.setId(itemUbigeoVO.getCodigo());
                itemDTO.setNombre(itemUbigeoVO.getNombre().trim());
                itemDTOs.add(itemDTO);
            }        

        return itemDTOs;        
    }
    
    
    @Override
    public String obtenerNombreProvincia(String codProvincia) {
        List<ComboItemDTO> itemDTOs = obtenerProvincias();
        for(ComboItemDTO combo:itemDTOs){
            if (combo.getId().equals(codProvincia)) {
                return combo.getNombre();
            }
        }
        return "";        
    }

    @Override
    public String obtenerNombreDistrito(String codDistrito) {
        List<ComboItemDTO> itemDTOs = obtenerDistritos();
        for(ComboItemDTO combo:itemDTOs){
            if (combo.getId().equals(codDistrito)) {
                return combo.getNombre();
            }
        }
        return "";  
    }*/
}




