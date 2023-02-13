package org.example;

public class Canvas {
        private String canvasEmail ;
       private String canvasPassword  ;
    Canvas(LoginInformation information){
            canvasEmail = information.getEmail();
            canvasPassword = information.getPassword();

        }

    public String getCanvasEmail() {
        return canvasEmail;
    }
    public String getCanvasPassword() {
        return canvasPassword;
    }
    public static void homePage(){

    }


}
