class SubstitutionCipher{
    String encrypt(String text, int key){
        text = text.toLowerCase();
        StringBuilder encryptedString = new StringBuilder(text.length());

        for (int i=0; i<text.length(); i++){
            int letterCode = text.charAt(i);

            if(letterCode != 32){
                letterCode += (key%26);
            }

            if(letterCode > 122) {
                letterCode = letterCode - 122 + 96;
            }
            encryptedString.append((char)letterCode);
        }
        return encryptedString.toString();
    }

    String decrypt(String text, int key){
        text = text.toLowerCase();
        StringBuilder decryptedString = new StringBuilder(text.length());

        for (int i=0; i<text.length(); i++){
            int letterCode = text.charAt(i);

            if(letterCode != 32){
            letterCode -= (key%26);
            }

            if(letterCode < 97 && letterCode!=32) {
                letterCode = letterCode + 26;
            }
            decryptedString.append((char)letterCode);
        }
        return decryptedString.toString();
    }
}

public class Practical01 {
    public static void main(String[] args) {
        String s1 = "Information Technology Department";
        int key = 96;

        SubstitutionCipher cipher = new SubstitutionCipher();
        System.out.println("Original: " + s1);
        String encryptedS1 = cipher.encrypt(s1, key);
        System.out.println("Encrypted: " + encryptedS1);
        String decryptedS1 = cipher.decrypt(encryptedS1, key);
        System.out.println("Decrypted: " + decryptedS1);
    }
}
