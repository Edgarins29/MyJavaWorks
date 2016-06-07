/* 
 * The MIT License
 *
 * Copyright 2014 Edgars Liepiņš.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package base64talk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;

/**
 *
 * @author edgars
 */

// Viens no defensive programming principiem, kas izmantoti ir skaisti noformēti un nobīdīti teksti,
// lai būtu labāk pārlasāmi.
// Vēl viens princips ir saprotami mainīgo nosaukumi.
// Vēl tiek veidoti komentāri, lai tiktu saprasta programmas darbība.

public class Base64 {

    // mainīgais, kurā sarakstīti 64 simboli, kurus izmantos kodēšanai.
    private final static String chars_b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    // mainīgais pēc cik simboliem tiks kodējums parādīts jaunā rindā.
    private static final int splitLinesAt = 76;

    // showMsgBox funkcija, kas iekapsulē dialoga funkciju.
    public static void showMsgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Funkcija, kas sadala parametrā norādīto simbolu virkni pa rindiņām ik pēc 76 simboliem
    public static String splitLines(String inputString) {

        String lines = "";
        int s = inputString.length();       // iegūstam ieejas virknes garumu
        if (s <= splitLinesAt) {            // ja s ir mazāks vai vienāds, tad to nedaram
            lines = inputString;            // tāpēc atgriešanas vērtība ir tā pati ieejas vērtība
        } else {
            for (int i = 0; i < s; i += splitLinesAt) {
                // atgriež apakšvirkni ik pēc sadalīšanas, ievieto jaunas
                // rindas simbolu un pieskaita iepriekšējai vērtībai
                lines += inputString.substring(i, Math.min(inputString.length(), i + splitLinesAt)) + "\r\n";
            }
        }
        return lines;
    }

    // nokodēšanas funkcija, kurai jāpadod un kura atgriež String simbolu virkni
    public static String encode(String inputString) throws UnsupportedEncodingException {
        byte[] data = inputString.getBytes("UTF-8");    // Ieejas simbolu virkni pārvēršam baitos ar UTF-8

        if (data == null) {                     // ja ievaddati neeksistē, tad
            inputString = null;                 // ieejas simbolu virkne ir nulle
        } else {
            try {
                ByteArrayOutputStream outStream;
                try (ByteArrayInputStream inStream = new ByteArrayInputStream(data)) {
                    outStream = new ByteArrayOutputStream();
                    encode(inStream, outStream);          // izsaucam nokodēšanas funkciju
                    outStream.flush();
                    outStream.close();
                }

                inputString = splitLines(new String(outStream.toByteArray())); // rezultāts tiek sadalīts par rindām
            } catch (IOException e) {
                inputString = null;
            }
        }
        return inputString;
    }

    // 2. Defensive programming princips - sadalīju encode un decode funkcijas vēl apakšfunkcijās,
    // lai labāk veidotos koda pārlasāmība
    public static void encode(InputStream in, OutputStream out) throws IOException {
        if (in == null || out == null) {        
            // ja datu nav, tad neko nedaram
        } else {
            byte[] buffer = new byte[3];        // baitu buferis
            int nBytesRead;                     // nolasīto baitu skaits
            int nPaddings = 0;                  // nepiciešamo papildinājumu skaits

            while ((nBytesRead = in.read(buffer)) > 0) {    // kamēr ir baiti, ko nolasīt
                if (nBytesRead == 1) {                      // ja nolasītie baiti ir viens, tad
                                                            // piepilda pedejos 2 baitus
                    buffer[1] = 0;
                    buffer[2] = 0;
                    nPaddings = 2;
                } else if (nBytesRead == 2) {               // ja nolasītie baiti ir 2, tad
                                                            // piepilda tikai pēdējo baitu
                    buffer[2] = 0;
                    nPaddings = 1;
                } else {
                    // netiek piepildits, jo nolasītais buferis jau pilns
                }
                // 0xff = 255
                // šos trīs baitus pārvēršam par daļām no viena 24 bitu skaitļa
                int n1 = (buffer[0] & 0xff) << 16;
                int n2 = (buffer[1] & 0xff) << 8;
                int n3 = (buffer[2] & 0xff);
                
                // iegūtās daļas saskaitam kopā
                int n = n1 + n2 + n3;

                byte[] result_data = new byte[4];
                // 0x3f = 63
                // 24 bitu skaitlis tiek pārvērsts 4 sešciparu skaitļos
                // un šie skaitļi tiek izmantoti kā indeksi base64 simbolu sarakstā
                result_data[0] = (byte) chars_b64.charAt((n >> 18) & 0x3f);
                result_data[1] = (byte) chars_b64.charAt((n >> 12) & 0x3f);

                if (nPaddings == 2) {               // ja tika piepildīti divi baiti, 
                    result_data[2] = (byte) '=';    // tad rezultātā pirmspēdējais tiek piepildīts
                } else {                            // citādākā gadījumā izmantojam indeksēto simbolu no saraksta
                    result_data[2] = (byte) chars_b64.charAt((n >> 6) & 0x3f);
                }

                if (nPaddings == 1 || nPaddings == 2) { // ja tika piepildīti viens vai divi baiti,
                    result_data[3] = (byte) '=';        // tad rezultātā pēdējais baits tiek piepildīts.
                } else {                                // citādākā gadījumā izmantojam indeksēto simbolu no saraksta
                    result_data[3] = (byte) chars_b64.charAt(n & 0x3f);
                }

                out.write(result_data);
                out.flush();
            }
        }
    }

    public static String decode(String inputString) {
        byte[] data;

        if (inputString == null) {      // Ja ieejas simbolu virknes nav, tada dati ir nulle
            data = null;
        } else if (inputString.length() == 0) { // Ja simbolu virknes izmēŗs ir 0, tad dati ir tukši
            data = new byte[0];
        } else {
            try {
                // no ieejas simbolu virknes noņemam visus simbolus no virknes izņemot to,
                // kas ir base64 simbolu sarakstā un '='
                String tmpStr = inputString.replaceAll("[^" + chars_b64 + "=]", "");
                byte[] b64data = tmpStr.getBytes("UTF-8");      // iegūtos datus saņemam UTF-8 formātā.
                ByteArrayOutputStream outStream;
                try (ByteArrayInputStream inStream = new ByteArrayInputStream(b64data)) {
                    outStream = new ByteArrayOutputStream();
                    decode(inStream, outStream);        // izsaucam dekodēšanas funkciju
                    outStream.flush();
                    outStream.close();
                }

                data = outStream.toByteArray();     // datu plūsmu pārvēršam uz baitu masīvu
                // 3. Defensive programming piemērs, nodrošināta Exception uzvedība
            } catch (UnsupportedEncodingException e) {
                data = null;
            } catch (IOException e) {
                data = null;
            }
        }
        String result;
        try {
            result = new String(data);      // rezultāta simbola virkne tiek iegūta no baitu masīva
        } catch (NullPointerException e) {
            result = null;
            showMsgBox("Nav īsta Base64 simbolu virkne ko dekodēt!");
        }

        return result;
    }

    public static void decode(InputStream inStream, OutputStream outStream) throws IOException {
        // 4. Defensive programming princips - apstrādāts gadījums, kad nav ievadīti dati
        if (inStream == null || outStream == null) {
            // neko nedaram
        } else {
            byte[] buffer = new byte[4];    // 4 baitu buferis
            int nBytesRead;             // nolasītie baiti
            while ((nBytesRead = inStream.read(buffer)) > 0) {      // kamēr ir dati, ko nolasīt
                if (nBytesRead != 4) {                              // ja nolasītie dati nav 4 baiti
                    showMsgBox("Ieejas dati nav pareizs Base64 kodējums; nolasītais bloks ir mazāks par 4 baitiem. Ievadi pareizu Base64 nokodētu tekstu.");
                } else {                                            // citādāk varam strādāt tālāk

                    // katrs simbols simbolizē 6 bitu indeksu no base64 simbolu saraksta,
                    // kuri pēc saskaitīšanas dos 24 bitu skaitli priekš oriģinālajiem
                    // 3 simboliem
                    char c0 = (char) buffer[0];                     
                    char c1 = (char) buffer[1];
                    char c2 = (char) buffer[2];
                    char c3 = (char) buffer[3];

                    byte b0 = (byte) chars_b64.indexOf(c0);
                    byte b1 = (byte) chars_b64.indexOf(c1);
                    byte b2 = (c2 == '=') ? 0 : (byte) chars_b64.indexOf(c2);
                    byte b3 = (c3 == '=') ? 0 : (byte) chars_b64.indexOf(c3);

                    int n0 = (b0 & 0x3f) << 18;
                    int n1 = (b1 & 0x3f) << 12;
                    int n2 = (b2 & 0x3f) << 6;
                    int n3 = (b3 & 0x3f);

                    int n = n0 + n1 + n2 + n3;
                    // pēdējā solī tiek 24 bitu skaitlis sadalīts oriģinālajos 3
                    // 8 bitu simbolos
                    outStream.write((byte) (n >> 16) & 0xff);
                    if (c2 != '=') {
                        outStream.write((byte) (n >> 8) & 0xff);
                    }
                    if (c3 != '=') {
                        outStream.write((byte) (n) & 0xff);
                    }
                }
            }
        }
    }

}
