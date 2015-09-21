/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.progvi.simplewsauthjava;

import br.org.catolicasc.progvi.wsauth.HelloWorld;
import br.org.catolicasc.progvi.wsauth.HelloWorldImplService;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author rodrigo
 */
public class SimpleWSAuthJava {
    private static final String WS_URL = "http://localhost:8080/SimpleWSAuth/HelloWorldImplService?wsdl";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        HelloWorldImplService hs = new HelloWorldImplService();
        HelloWorld hw = hs.getHelloWorldImplPort();
        
        // Username e password
        Map<String, Object> req_ctx = ((BindingProvider)hw).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
        
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList("aluno"));
        headers.put("Password", Collections.singletonList("1234"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        // Fim usuario e senha
        
        System.out.println(hw.getHelloWorldAsString());
        
    }
    
    
}
