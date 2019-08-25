package org.soyphea.gateway.validation;

public class AuthorizationHeaderValidation {

    public static boolean isAuthorizationValid(String authorizationHeader) {
        //Pattern p = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");
        //return p.matcher(authorizationHeader).matches();
        return true;
    }


}
