package com.minila.ldap;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldif.LDIFReader;
 
@RestController
public class LdapController {
 
    @Autowired
    private PersonRepo personRepo;
     
    @GetMapping("/get-user-names")
    public ResponseEntity<List<String>> getLdapUserNames() {
        return new ResponseEntity<>(personRepo.getAllPersonNames(), HttpStatus.OK);
    }
 
    @GetMapping("/get-users")
    public ResponseEntity<List<Person>> getLdapUsers() {
        return new ResponseEntity<>(personRepo.getAllPersons(), HttpStatus.OK);
    }
 
    @GetMapping("/get-user")
    public ResponseEntity<Person> findLdapPerson(@RequestParam(name = "user-id") String userId) {
        return new ResponseEntity<>(personRepo.getPersonNamesByUid(userId), HttpStatus.OK);
    }
    
   
}
