package es.cic.curso;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.web.context.ContextLoader;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import es.cic.ejemploREST.servicios.CineService;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    
	private Grid maestro;
	private PersonaForm detalle;
	
	private List<Persona> alumnosClase;
	
	private CineService cineService;
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        cineService = ContextLoader.getCurrentWebApplicationContext().getBean(CineService.class);
        
        
        Button botonMensaje = new Button("Bienvenido al mundo real");
        
        botonMensaje.addClickListener(e -> Notification.show(cineService.dameMensaje()));

        
        alumnosClase = new ArrayList<>();
        alumnosClase.add(new Persona("Roberto", "Alcazar"));
        alumnosClase.add(new Persona("Pedrín", "NN"));
        
        maestro = new Grid();
        maestro.setColumns("firstName", "lastName");
        
        cargaGrid();
        
        maestro.addSelectionListener(e -> 
        	{
        		Persona p = null;
        		if (!e.getSelected().isEmpty() ) {
	        		p = (Persona) e.getSelected().iterator().next();
        		} 
        		detalle.setPersona(p);
        	});
        
        detalle = new PersonaForm(this);
        
        
        layout.addComponents(botonMensaje, maestro, detalle);
        layout.setMargin(true);
        layout.setSpacing(true);
       
        
        
        setContent(layout);
    }

	public void cargaGrid() {
		maestro.setContainerDataSource(
        		new BeanItemContainer<>(Persona.class, alumnosClase)
        );
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
