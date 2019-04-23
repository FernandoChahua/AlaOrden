package com.myorg.web.controller;

import com.myorg.core.entity.Franquicia;
import com.myorg.core.entity.Sede;
import com.myorg.core.service.IFranquiciaService;
import com.myorg.core.service.ISedeService;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class SedeController {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IFranquiciaService franquiciaSerivice;
    
    @Inject 
    private ISedeService sedeService;
    
    private Sede sede;
    private Sede sedeSe;
    private List<Sede> sedes;
    
    private Franquicia franquicia;
    private List<Franquicia> franquicias;
    
    
    
    
}
