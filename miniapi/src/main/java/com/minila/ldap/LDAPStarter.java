package com.minila.ldap;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldif.LDIFReader;

@RestController
public class LDAPStarter {
	
	 @GetMapping("/start")
	    public ResponseEntity<Person> start() throws LDAPException, UnknownHostException {
	    	
	    	InMemoryListenerConfig listenerConfig = new InMemoryListenerConfig("listener", InetAddress.getByName("127.0.0.1"),8082, null, null, null);
	    	
	    	InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig("dc=springframework,dc=org");
	    	config.setListenerConfigs(listenerConfig);
	    	config.addAdditionalBindCredentials("uid=admin", "secret");
	    	
//	    	config.getSchema().
	    	InMemoryDirectoryServer directoryServer = new InMemoryDirectoryServer(config);
	    	directoryServer.importFromLDIF(true, new LDIFReader(ClassLoader.getSystemResourceAsStream("minila-ldap.ldif")));
	        directoryServer.startListening();
	        

	         LDAPConnection ldapConnection = directoryServer.getConnection();
	    	
	    	
	    	
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

}
