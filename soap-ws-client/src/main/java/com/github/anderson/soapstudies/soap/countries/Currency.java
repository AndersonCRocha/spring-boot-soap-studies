//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.01.28 às 08:48:15 PM BRT 
//


package com.github.anderson.soapstudies.soap.countries;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de currency.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="currency"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BRL"/&gt;
 *     &lt;enumeration value="USD"/&gt;
 *     &lt;enumeration value="EUR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "currency")
@XmlEnum
public enum Currency {

    BRL,
    USD,
    EUR;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
