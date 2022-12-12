//package com.example.demo.Model;
//
//import javax.websocket.Session;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//
//
//public class SendEmailAPI {
//    private String host;
//    private int port;
//    private boolean debug;
//
//    private String username;
//    private String password;
//
//    private String senderEmail;
//
//    public SendEmailAPI() {
//
//        host  = "smtp.gmail.com";
//        port = 587;
//        debug = true;
//
//        username = "hoichua1000@gmail.com";
//        password = "mpyebakdzbzlrjnx";
//
//        senderEmail = "hoichua1000@gmail.com";
//    }
//
//    public SendEmailAPI( String host, int port, String username, String password, String senderEmail ) {
//
//        this.host  = host;
//        this.port = port;
//        this.debug = true;
//
//        this.username = username;
//        this.password = password;
//
//        this.senderEmail = senderEmail;
//    }
//
//    public void sendMail( String to, String subject, String content ) {
//
//        // Set Properties
//        Properties props = new Properties();
//
//        props.put( "mail.smtp.auth", "true" );
//        props.put( "mail.smtp.host", host );
//        props.put( "mail.smtp.port", port );
//        props.put( "mail.smtp.starttls.enable", "true" );
//        props.put( "mail.debug", debug );
//        props.put( "mail.smtp.socketFactory.port", port );
//        //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        props.put( "mail.smtp.socketFactory.fallback", "false" );
//        props.put( "mail.smtp.ssl.trust", host );
//
//        // Create the Session Object
//        Session session = Session.getInstance(
//                props,
//                new javax.mail.Authenticator() {
//
//                    protected PasswordAuthentication getPasswordAuthentication() {
//
//                        return new PasswordAuthentication( username, password );
//                    }
//                }
//        );
//
//        try {
//
//            MimeMessage message = new MimeMessage( session );
//
//            // From
//            message.setFrom( new InternetAddress( senderEmail ) );
//
//            // Reply To
//            message.setReplyTo( InternetAddress.parse( senderEmail ) );
//
//            // Recipient
//            message.addRecipient( Message.RecipientType.TO, new InternetAddress( to ) );
//
//            // Subject
//            message.setSubject( subject );
//
//            // Content
//            message.setContent( content, "text/html; charset=utf-8" );
//
//            Transport.send( message );
//
//        }
//        catch( MessagingException exc ) {
//            exc.printStackTrace();
//            throw new RuntimeException( exc );
//        }
//    }
//
////    public static void main( String[] args ) {
////
////        SendEmailAPI sendEmailAPI = new SendEmailAPI();
////
////
////
