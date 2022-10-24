package edu.umb.cs680.hw05;

public interface State {
    public void login(SecurityContext ctx, EncryptedString pwd) throws Exception;
    public void logout(SecurityContext ctx);
}