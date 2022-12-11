package edu.umb.cs680.hw13.Authentication;

public class Authenticator {
    public static boolean authenticate(SecurityContext ctx, EncryptedString password){
        // Dummy code to test failure of printjob execution
        if (password.getEncryptedString().equals("<encryption>1234<encryption>") || password.getEncryptedString().equals("<encryption>bat123<encryption>")){
            return true;
        }
        return false;
    }
}
