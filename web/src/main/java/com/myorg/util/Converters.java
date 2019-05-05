package com.myorg.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@SessionScoped
public class Converters implements Serializable {

    public Converter getLocalDateConverter() {
        return new Converter() {

            @Override
            public Object getAsObject(
                    FacesContext context,
                    UIComponent component,
                    String value) {
                YearMonth ym = YearMonth.parse(value, DateTimeFormatter.ofPattern("MM/yy"));
                return ym.atDay(1);
            }

            @Override
            public String getAsString(
                    FacesContext context,
                    UIComponent component,
                    Object value) {
                return ((LocalDate) value).format(DateTimeFormatter.ofPattern("MM/yy"));
            }
        };
    }

    public Converter getLocalDateTimeConverter() {
        return new Converter() {

            @Override
            public Object getAsObject(
                    FacesContext context,
                    UIComponent component,
                    String value) {

                LocalDateTime ldt = null;
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    Date d = format.parse(value);
                    ldt = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    
                } catch (ParseException e)
                {
                }
                return ldt;
            }

            @Override
            public String getAsString(
                    FacesContext context,
                    UIComponent component,
                    Object value) {
                return ((LocalDateTime) value).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
            }
        };
    }

}
