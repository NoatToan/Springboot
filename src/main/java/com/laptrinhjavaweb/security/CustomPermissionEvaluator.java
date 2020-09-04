package com.laptrinhjavaweb.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Override    
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetDomainObject.toString().toUpperCase(), permission.toString().toUpperCase());}

    @Override    
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(), permission.toString().toUpperCase());}

    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
//        for (CustomGrantedAuthority grantedAuth : (List<CustomGrantedAuthority>) auth.getAuthorities()) {
//            for (String grantedPermission : grantedAuth.getPermissions()) {
//                if (grantedPermission.startsWith(targetType) && grantedPermission.contains(permission)) {
//                    return true;
//                 }
//            }
//        }
        return false;
    }
}