package mvx.app.pgm.customer;

import mvx.app.pgm.common.*;
import mvx.dsp.common.GenericDSP;
import mvx.dsp.common.interactive;
import mvx.dsp.obj.*;
import mvx.util.*;

public class ZMS304 extends Interactive {

    // - Position cursor
public void PBINZ() {
        // - Position cursor
        DSP.setFocus(6, 6, "W1CUNO");
        switch(0){
            default
        // - Init of subfile information switch (0)
        if (IN61) {
            XXCUNO.move(DSP.W1CUNO);
            XXPRRF.move(DSP.W1PRRF);
            XXITNO.move(DSP.W1ITNO);
            break;
        } else if (IN62) {
            XX00YN.move(DSP.W200YN);
            XXCUNO.move(DSP.W2CUNO);
            XXPRRF.move(DSP.W2PRRF);
            XXITNO.move(DSP.W2ITNO);
            break;
        } else if (IN63) {
            XXUSID.move(DSP.W3USID);
            XXCUNO.move(DSP.W3CUNO);
            XXPRRF.move(DSP.W3PRRF);
            XXITNO.move(DSP.W3ITNO);
            break;
        } else if (IN64) {
            X4RGDT = DSP.W4RGDT;
            X4RGTM = DSP.W4RGTM;
            XXUSID.move(DSP.W4USID);
            XXCUNO.move(DSP.W4CUNO);
            XXPRRF.move(DSP.W4PRRF);
            XXITNO.move(DSP.W4ITNO);
            break;
        } else if (IN65) {
            X5RGDT = DSP.W5RGDT;
            XX00YN.move(DSP.W500YN);
            XXUSID.move(DSP.W5USID);
            XXCUNO.move(DSP.W5CUNO);
            XXPRRF.move(DSP.W5PRRF);
            XXITNO.move(DSP.W5ITNO);
            break;
        }
    }
    XLCUNO.clear();
    XLPRRF.clear(); 
    XLITNO.clear(); 
    XLFVDT = 0; 
    XL00YN.clear(); 
    XLBJNO.clear(); 
    XLUSID.clear(); 
    XLRGDT = 0; 
    XLRGTM = 0; 
    this.WSRGTM = movexTime(); 
    DSP.XBRRNA = 0; 
    DSP.XBRRNM = 0; 
    IN94 = true; 
    IN95 = false; 
    DSP.clearSFL("BC"); 
    IN94 = false; 
    IN95 = false; 
    IN96 = false; // - Set limit & build subfile 
    // - Question type 1 
    if (IN61) 
    { 
        ZQBAS.setCUNO().move(DSP.W1CUNO); 
        ZQBAS.setPRRF().move(DSP.W1PRRF); 
        ZQBAS.setITNO().move(DSP.W1ITNO); 
        ZQBAS.SETLL_SCAN("30", ZQBAS.getKey("30")); 
    } // - Question type 2 
    if (IN62) { 
        ZQBAS.set00YN().move(DSP.W200YN); 
        ZQBAS.setCUNO().move(DSP.W2CUNO); 
        ZQBAS.setPRRF().move(DSP.W2PRRF); 
        ZQBAS.setITNO().move(DSP.W2ITNO); 
        ZQBAS.SETLL_SCAN("40", ZQBAS.getKey("40")); 
    } // - Question type 3 
 
    if (IN63) { 
         
        ZQBAS.setCHID().move(DSP.W3USID); 
         
        ZQBAS.setCUNO().move(DSP.W3CUNO); 
         
        ZQBAS.setPRRF().move(DSP.W3PRRF); 
         
        ZQBAS.setITNO().move(DSP.W3ITNO); 
         
        ZQBAS.SETLL_SCAN("50", ZQBAS.getKey("50")); 
    } 
    // - Question type 4 
     
    if (IN64) { 
        ZQBAS.setRGDT(DSP.W4RGDT); 
        ZQBAS.setRGTM(DSP.W4RGTM); 
        ZQBAS.setCHID().move(DSP.W4USID); 
        ZQBAS.setCUNO().move(DSP.W4CUNO); 
         
        ZQBAS.setPRRF().move(DSP.W4PRRF); 
         
        ZQBAS.setITNO().move(DSP.W4ITNO); 
        //A 
        ZQBAS.SETLL_SCAN("60", ZQBAS.getKey("60")); 
    } //A BSLTRM00420 250529 
    // - Question type 5 
     
    if(IN65){ 
        ZQBAS.setRGDT(DSP.W5RGDT); 
        ZQBAS.set00YN().move(DSP.W500YN); 
        ZQBAS.setCHID().move(DSP.W5USID); 
        ZQBAS.setCUNO().move(DSP.W5CUNO); 
        ZQBAS.setPRRF().move(DSP.W5PRRF); 
        ZQBAS.setITNO().move(DSP.W5ITNO); 
        ZQBAS.SETLL_SCAN("70", ZQBAS.getKey("70")); 
    } 
    PBINZ_SETLL();
    PBROL();
}

/** * PBDSP - Display */ 
public String PBDSP_getWriteNames() 
{ return "BF,BC"; } 
public String PBDSP_getReadNames() 
{ return "BC"; } 
/** * PBCHK - Check */ 
public void PBCHK() 
{
    DSP.WBRRNA = 0; 
    DSP.WSOPT2.move(DSP.WWOPT2); // - Sequence must be entered 
    if (!seqCheckSeq("E-", DSP.WWPSEQ)) 
    { 
        return; 
    } 
    this.CSSQ.moveLeft(this.SEQ); 
    PBCHKX: 
    do // goto PBCHKX loop 
    { 
        //These are the fields where you search for the data you are looking for and it will show only that data 
        if (IN61) { 
            ZQBAS.setCUNO().move(DSP.W1CUNO); 
            ZQBAS.setPRRF().move(DSP.W1PRRF); 
            ZQBAS.setITNO().move(DSP.W1ITNO); 
        } else if (IN62) {
            ZQBAS.set00YN().move(DSP.W200YN);
            ZQBAS.setCUNO().move(DSP.W2CUNO);
            ZQBAS.setPRRF().move(DSP.W2PRRF);
            ZQBAS.setITNO().move(DSP.W2ITNO);
        } else if (IN63) {
            ZQBAS.setCHID().move(DSP.W3USID);
            ZQBAS.setCUNO().move(DSP.W3CUNO);
            ZQBAS.setPRRF().move(DSP.W3PRRF);
            ZQBAS.setITNO().move(DSP.W3ITNO);
        } else if (IN64) {
            ZQBAS.setRGDT(DSP.W4RGDT);
            ZQBAS.setRGTM(DSP.W4RGTM);
            ZQBAS.setCHID().move(DSP.W4USID);
            ZQBAS.setCUNO().move(DSP.W4CUNO);
            ZQBAS.setPRRF().move(DSP.W4PRRF);
            ZQBAS.setITNO().move(DSP.W4ITNO);
        } else if (IN65) {
            ZQBAS.setRGDT(DSP.W5RGDT);
            ZQBAS.set00YN().move(DSP.W500YN);
            ZQBAS.setCHID().move(DSP.W5USID);
            ZQBAS.setCUNO().move(DSP.W5CUNO);
            ZQBAS.setPRRF().move(DSP.W5PRRF);
            ZQBAS.setITNO().move(DSP.W5ITNO);
        }
    }
    // Questiontype
    if (!PBCHK_ValidateInquiry()) {
        if (DSP.WWQTTP != 1 && DSP.WWQTTP != 2 && DSP.WWQTTP != 3 && //A BSLTRM00420 250529
            DSP.WWQTTP != 4 && //A BSLTRM00420 250529
            DSP.WWQTTP != 5 //A BSLTRM00420 250603
        ) {
            picSetMethod('D');
            IN60 = true;
            DSP.setFocus(5, 2, "WWQTTP"); // MSGID=WQT0101 Inquiry type &1 is invalid
            COMPMQ("WQT0101", formatToString(DSP.WWQTTP, 2));
            break PBCHKX;
        }
    }
    //Below code is responsible to show the data on the B-Panel's screen for both the Question Types
    if (DSP.WWQTTP == 1 && !IN61) {
        moveToIN(61, "000000");
        IN61 = true;
        DSP.W1CUNO.move(ZQBAS.getCUNO());
        DSP.W1PRRF.move(ZQBAS.getPRRF());
        DSP.W1ITNO.move(ZQBAS.getITNO());
        DSP.W1FVDT = ZQBAS.getFVDT();
        DSP.W100YN.move(ZQBAS.get00YN());
        picSetMethod('I');
        break PBCHKX;
    } else if (DSP.WWQTTP == 2 && !IN62) {
        moveToIN(62, "000000");
        IN62 = true;
        DSP.W2CUNO.move(ZQBAS.getCUNO());
        DSP.W2PRRF.move(ZQBAS.getPRRF());
        DSP.W2ITNO.move(ZQBAS.getITNO());
        DSP.W200YN.move(ZQBAS.get00YN());
        picSetMethod('I');
        break PBCHKX;
    } else if (DSP.WWQTTP == 3 && !IN63) {
        moveToIN(63, "000000");
        IN63 = true;
        DSP.W3USID.move(ZQBAS.getCHID());
        DSP.W3CUNO.move(ZQBAS.getCUNO());
        DSP.W3PRRF.move(ZQBAS.getPRRF());
        DSP.W3ITNO.move(ZQBAS.getITNO());
        picSetMethod('I');
        break PBCHKX;
    } else if (DSP.WWQTTP == 4 && !IN64) {
        moveToIN(64, "000000");
        IN64 = true;
        DSP.W4RGDT = ZQBAS.getRGDT();
        DSP.W4RGTM = ZQBAS.getRGTM();
        DSP.W4USID.move(ZQBAS.getCHID());
        DSP.W4CUNO.move(ZQBAS.getCUNO());
        DSP.W4PRRF.move(ZQBAS.getPRRF());
        DSP.W4ITNO.move(ZQBAS.getITNO());
        picSetMethod('I');
        break PBCHKX;
    } else if (DSP.WWQTTP == 5 && !IN65) {
        moveToIN(65, "000000");
        IN65 = true;
        DSP.W5RGDT = ZQBAS.getRGDT();
        DSP.W5USID.move(ZQBAS.getCHID());
        DSP.W5CUNO.move(ZQBAS.getCUNO());
        DSP.W5PRRF.move(ZQBAS.getPRRF());
        DSP.W5ITNO.move(ZQBAS.getITNO());
        DSP.W500YN.move(ZQBAS.get00YN());
        picSetMethod('I');
    }
//Code for Searching blocks below each column 
switch(0)
{ 
    default: 
    if (IN61) 
    { 
        ZQBAS.setCUNO().move(DSP.W1CUNO); 
        ZQBAS.setPRRF().move(DSP.W1PRRF); 
        ZQBAS.setITNO().move(DSP.W1ITNO); 
        ZQBAS.setFVDT(DSP.W1FVDT); 
        ZQBAS.set00YN().move(DSP.W100YN); 
        break; 
    } 
    if (IN62) 
    { 
        ZQBAS.set00YN().move(DSP.W200YN); 
        ZQBAS.setCUNO().move(DSP.W2CUNO); 
        ZQBAS.setPRRF().move(DSP.W2PRRF); 
        ZQBAS.setITNO().move(DSP.W2ITNO); 
        break; 
    } 
    if (IN63) { //A BSLTRM00420 250529 
        ZQBAS.setCHID().move(DSP.W3USID); //A BSLTRM00420 250529 
        ZQBAS.setCUNO().move(DSP.W3CUNO); //A BSLTRM00420 250529 
        ZQBAS.setPRRF().move(DSP.W3PRRF); //A BSLTRM00420 250529 
        ZQBAS.setITNO().move(DSP.W3ITNO); //A BSLTRM00420 250529 
        break; //A BSLTRM00420 250529 
    } //A BSLTRM00420 250529 
    if (IN64) { //A BSLTRM00420 250529 
        ZQBAS.setRGDT(DSP.W4RGDT); //A BSLTRM00420 250529 
        ZQBAS.setRGTM(DSP.W4RGTM); //A BSLTRM00420 250529 
        ZQBAS.setCHID().move(DSP.W4USID); //A BSLTRM00420 250529 
        ZQBAS.setCUNO().move(DSP.W4CUNO); //A BSLTRM00420 250529 
        ZQBAS.setPRRF().move(DSP.W4PRRF); //A BSLTRM00420 250529 
        ZQBAS.setITNO().move(DSP.W4ITNO); //A BSLTRM00420 250529 
        break; //A BSLTRM00420 250529 
    } //A BSLTRM00420 250529 
    if (IN65) { //A BSLTRM00420 250619 
        ZQBAS.setRGDT(DSP.W5RGDT); 
        ZQBAS.set00YN().move(DSP.W500YN); 
        ZQBAS.setCHID().move(DSP.W5USID); 
        ZQBAS.setCUNO().move(DSP.W5CUNO); 
        ZQBAS.setPRRF().move(DSP.W5PRRF); 
        ZQBAS.setITNO().move(DSP.W5ITNO); 
        break; 
    } 
    if (DSP.WSOPT2.isBlank() && DSP.XBRRNM != 0) 
    { 
        do { 
            DSP.WBRRNA = 0; 
            IN93 = DSP.readSFL("BS");
             ZQBAS.setCUNO().move(DSP.WSCUNO); 
             ZQBAS.setPRRF().move(DSP.WSPRRF); 
             ZQBAS.setITNO().move(DSP.WSITNO); 
             ZQBAS.setFVDT(DSP.WSFVDT); 
             ZQBAS.set00YN().move(DSP.WS00YN); 
             ZQBAS.setCHID().move(DSP.WSUSID); 
             ZQBAS.setRGDT(DSP.WSRGDT); 
             ZQBAS.setRGTM(DSP.WSRGTM); //A BSLTRM00420 250529
             ZQBAS.setBJNO().move(DSP.WSBJNO); 
             ZQBAS.setRESN().move(DSP.WSRESN); 
            }
             while (!(IN93 || !DSP.WSOPT2.isBlank())); 
            } 
            // New start position 
            if (DSP.WSOPT2.isBlank()) 
            { 
                if (IN61) { 
                    if (DSP.W1CUNO.NE(XXCUNO) || DSP.W1PRRF.NE(XXPRRF) || DSP.W1ITNO.NE(XXITNO))
                    {
                         //// DSP.W100YN.NE(XX00YN)){ //D BSLTRM00420 250529 
                        picSetMethod('I'); 
                        break PBCHKX; 
                    } 
                } 
                if (IN62) 
                { 
                    if (DSP.W200YN.NE(XX00YN) || 
                      DSP.W2CUNO.NE(XXCUNO) || 
                      DSP.W2PRRF.NE(XXPRRF) || 
                      DSP.W2ITNO.NE(XXITNO))
                      {
                          //// DSP.W2USID.NE(XXUSID) || //D BSLTRM00420 250602 
                          //// DSP.W2BJNO.NE(XXBJNO)) { //D BSLTRM00420 250602 
                          picSetMethod('I'); 
                          break PBCHKX; 
                      } 
                } 
                if (IN63) { //A BSLTRM00420 250529 
                    if (DSP.W3USID.NE(XXUSID) || //A BSLTRM00420 250529 
                        DSP.W3CUNO.NE(XXCUNO) || //A BSLTRM00420 250529 
                        DSP.W3PRRF.NE(XXPRRF) || //A BSLTRM00420 250529 
                        DSP.W3ITNO.NE(XXITNO)) { //A BSLTRM00420 250529 
                        picSetMethod('I'); //A BSLTRM00420 250529 
                        break PBCHKX; //A BSLTRM00420 250529 
                    } //A BSLTRM00420 250529 
                } //A BSLTRM00420 250529 
                if (IN64) { //A BSLTRM00420 250529 
                    if (DSP.W4RGDT.NE(X4RGDT) || //A BSLTRM00420 250529 
                        DSP.W4RGTM.NE(X4RGTM) || //A BSLTRM00420 250529 
                        DSP.W4USID.NE(XXUSID) || //A BSLTRM00420 250529 
                        DSP.W4CUNO.NE(XXCUNO) || //A BSLTRM00420 250529 
                        DSP.W4PRRF.NE(XXPRRF) || //A BSLTRM00420 250529 
                        DSP.W4ITNO.NE(XXITNO)) { //A BSLTRM00420 250529 
                        picSetMethod('I'); //A BSLTRM00420 250529 
                        break PBCHKX; //A BSLTRM00420 250529 
                    } //A BSLTRM00420 250529 
                } //A BSLTRM00420 250529
                if (IN65) { //A BSLTRM00420 250619 
                    if (DSP.W5RGDT.NE(X5RGDT) || 
                        DSP.W500YN.NE(XX00YN) || 
                        DSP.W5USID.NE(XXUSID) || 
                        DSP.W5CUNO.NE(XXCUNO) || 
                        DSP.W5PRRF.NE(XXPRRF) || 
                        DSP.W5ITNO.NE(XXITNO)) { 
                        picSetMethod('I'); 
                        break PBCHKX; 
                    } 
                }
                PBCHK_CheckStartPosition(); 
            } 
            if (DSP.WSOPT2.isBlank()) 
            { 
                picSetMethod('D');
                break PBCHKX; 
                } // Check option
                this.XXOPT2.move(DSP.WSOPT2); 
                if (PxCHKoption()) 
                { break PBCHKX; 
                } 
                // - Reset picture mode indicators 
                moveToIN(41, "00000"); 
                // - Set picture sequence 
                seqLoadSavedSeq(); 
                // - Valid option 
                if (!PBCHK_ValidateOption())
                { 
                    if (
                        this.XXOPT2.NE(" 1")&& 
                        this.XXOPT2.NE(" 2") && 
                        this.XXOPT2.NE(" 3") && //A BSLTRM00420 250529 
                        this.XXOPT2.NE(" 4") && 
                        this.XXOPT2.NE(" 5") && 
                        this.XXOPT2.NE("11")) {//Option 11 is to re-process the data with 'NO' flag 
                            picSetMethod('D'); 
                            IN60 = true; 
                            if (DSP.WBRRNA == 0) { 
                                DSP.setFocus(6, 2, "WWOPT2"); 
                            } 
                            // MSGID=WOP0101 Option &1 is invalid 
                            COMPMQ("WOP0101", formatToString(this.XXOPT2)); 
                            break PBCHKX; 
                        } 
                    // - Allowed option 
                } 
                this.XI = 0; 
                this.XI = ((this.XI/10) * 10) + toInt(this.XXOP22.getChar()); 
                if (this.XI >= 1 && this.XI <= 9 && this.XXOP21.getChar() == ' ') { 
                    if (this.PXO.charAt(this.XI - 1) == '0') { 
                        picSetMethod('D'); 
                        IN60 = true; 
                        if (DSP.WBRRNA == 0) { 
                            DSP.setFocus(6, 2, "WWOPT2"); 
                        } 
                        // MSGID=XAU0001 You do not have authorization for the selected option 
                        COMPMQ("XAU0001"); 
                        break PBCHKX; 
                    } 
                }
                // - Check record 
                if (IN61) { 
                    IN91 = !ZQBAS.CHAIN("30", ZQBAS.getKey("30")); 
                    IN92 = ZQBAS.getErr("30"); 
                } 
                if (IN62) { 
                    IN91 = !ZQBAS.CHAIN("40", ZQBAS.getKey("40")); 
                    IN92 = ZQBAS.getErr("40"); 
                } 
                if (IN63) { 
                    IN91 = !ZQBAS.CHAIN("50", ZQBAS.getKey("50")); 
                    IN92 = ZQBAS.getErr("50"); 
                } 
                if (IN64) { 
                    IN91 = !ZQBAS.CHAIN("60", ZQBAS.getKey("60")); 
                    IN92 = ZQBAS.getErr("60"); 
                } 
                if (IN65) { 
                    IN91 = !ZQBAS.CHAIN("70", ZQBAS.getKey("70")); 
                    IN92 = ZQBAS.getErr("70"); 
                } 
                // - Change mode (42) 
                if (this.XXOPT2.EQ(" 2")) { 
                    if (!IN91) { 
                        IN42 = true; 
                        picSetMethod('U'); 
                        this.SQ = 1; 
                        picPush('E', 'I'); 
                    } else { 
                        picSetMethod('D'); 
                        IN60 = true; 
                        DSP.setFocus(6, 6, "W1CUNO"); 
                        break PBCHKX; 
                    } 
                } 
                // - Delete mode (44) 
                if (!seqDeleteModeOk()) { 
                    DSP.setFocus(6, 6, "W1CUNO"); 
                    // // MSGID=XRE0103 Record does not exist 
                    // COMPMQ("XRE0103"); 
                    // MSGID=XRE0105 Confirm deletion of the record 
                    COMPMQ("XRE0105"); 
                    IN44 = true; 
                    picSetMethod('U'); 
                    picPush('D', 'I'); 
                    break PBCHKX; 
                } 
                // - Display mode (45) 
                if (!seqDisplayModeOk()) { 
                    DSP.setFocus(6, 6, "W1CUNO"); 
                    // MSGID=XRE0103 Record does not exist 
                    COMPMQ("XRE0103"); 
                    break PBCHKX; 
                }
                // -Related Option(Submit CTRL+11) 
                if (this.XXOPT2.EQ("11")) { 
                    ZQBAS.setCONO(LDAZD.CONO); 
                    ZQBAS.setCUNO().moveLeftPad(DSP.WSCUNO); 
                    ZQBAS.setPRRF().moveLeftPad(DSP.WSPRRF); 
                    ZQBAS.setITNO().moveLeftPad(DSP.WSITNO); 
                    IN91 = !ZQBAS.CHAIN("30", ZQBAS.getKey("30", 4)); 
                    validateData(); 
                    //Updating the data in the table OPRBAS only if the 00YN field has YES value 
                    if(ZQBAS.get00YN().equals("Yes")){ 
                        PRBAS.setCONO(LDAZD.CONO); 
                        PRBAS.setITNO().moveLeftPad(ZQBAS.getITNO()); 
                        PRBAS.setPRRF().moveLeftPad(ZQBAS.getPRRF()); 
                        IN91 = !PRBAS.CHAIN_LOCK("20", PRBAS.getKey("20", 3)); 
                        if (!IN91) { 
                            PRBAS.setCUNO().moveLeftPad(ZQBAS.getCUNO()); 
                            PRBAS.setPRRF().moveLeftPad(ZQBAS.getPRRF()); 
                            PRBAS.setITNO().moveLeftPad(ZQBAS.getITNO()); 
                            PRBAS.setSAPR(ZQBAS.getSAPR()); 
                            PRBAS.setSPNR(ZQBAS.getSAPR()); 
                            PRBAS.setFVDT(ZQBAS.getFVDT()); 
                            PRBAS.setRGDT(movexDate()); 
                            PRBAS.setRGTM(movexTime()); 
                            PRBAS.setLMDT(movexDate()); 
                            PRBAS.setCHNO(1); 
                            PRBAS.setCHID().moveLeftPad(this.DSUSS); 
                            PRBAS.UPDAT("20"); 
                        }else{
                            PRBAS.setCONO(100); 
                            PRBAS.setDIVI().move(PXDIVI); 
                            PRBAS.setPRRF().moveLeftPad(ZQBAS.getPRRF()); 
                            PRBAS.setCMNO().moveLeftPad(" "); 
                            PRBAS.setCUCD().moveLeftPad("USD"); 
                            PRBAS.setCUNO().moveLeftPad(ZQBAS.getCUNO()); 
                            PRBAS.setFVDT(ZQBAS.getFVDT()); 
                            PRBAS.setITNO().moveLeftPad(ZQBAS.getITNO()); 
                            PRBAS.setNTCD(0); 
                            PRBAS.setBNCD(0); 
                            PRBAS.setPRAC(0); 
                            PRBAS.setSAPR(ZQBAS.getSAPR()); 
                            PRBAS.setSPNR(ZQBAS.getSAPR()); 
                            PRBAS.setSACD(1); 
                            PRBAS.setSPUN().moveLeftPad(" "); 
                            PRBAS.setMXID().moveLeftPad(" "); 
                            PRBAS.setSGGU().moveLeftPad(" "); 
                            PRBAS.setLVDT(PRICH.getLVDT()); 
                            PRBAS.setTINC(0); 
                            PRBAS.setVTCD(0); 
                            PRBAS.setPRIX(0); 
                            PRBAS.setACGR(); 
                            PRBAS.setFMID(); 
                            PRBAS.setRESI(); 
                            PRBAS.setRGDT(movexDate()); 
                            PRBAS.setRGTM(movexTime()); 
                            PRBAS.setLMDT(movexDate()); 
                            PRBAS.setCHNO(1); 
                            PRBAS.setCHID().moveLeftPad(this.DSUSS); 
                            PRBAS.WRITE("20"); 
                        } 
                        ZRBAS.setCONO(LDAZD.CONO); 
                        ZRBAS.setITNO().moveLeftPad(ZQBAS.getITNO()); 
                        ZRBAS.setPRRF().moveLeftPad(ZQBAS.getPRRF()); 
                        IN91 = !ZRBAS.CHAIN_LOCK("20", ZRBAS.getKey("20", 3)); 
                        if(!IN91){ 
                            ZRBAS.setCUCD().move(PRBAS.getCUCD()); 
                            ZRBAS.setCUNO().moveLeftPad(ZQBAS.getCUNO()); 
                            ZRBAS.setFVDT(ZQBAS.getFVDT()); 
                            ZRBAS.setZORI().moveLeftPad("M"); 
                            ZRBAS.setRGDT(movexDate()); 
                            ZRBAS.setRGTM(movexTime()); 
                            ZRBAS.setLMDT(movexDate()); 
                            ZRBAS.setCHNO(1); 
                            ZRBAS.setCHID().moveLeftPad(this.DSUSS); 
                            ZRBAS.setZCDT(movexDate()); 
                            ZRBAS.UPDAT("20");
                            }else{ 
                            ZRBAS.setCONO(LDAZD.CONO); 
                            ZRBAS.setPRRF().moveLeftPad(ZQBAS.getPRRF()); 
                            ZRBAS.setCUCD().move(PRBAS.getCUCD()); 
                            ZRBAS.setCUNO().moveLeftPad(ZQBAS.getCUNO()); 
                            ZRBAS.setFVDT(ZQBAS.getFVDT()); 
                            ZRBAS.setITNO().moveLeftPad(ZQBAS.getITNO()); 
                            ZRBAS.setZLMA(0); 
                            ZRBAS.setZFCO(0); 
                            ZRBAS.setZORI().moveLeftPad("M"); 
                            ZRBAS.setRGDT(movexDate()); 
                            ZRBAS.setRGTM(movexTime()); 
                            ZRBAS.setLMDT(movexDate()); 
                            ZRBAS.setCHNO(1); 
                            ZRBAS.setCHID().moveLeftPad(this.DSUSS); 
                            ZRBAS.setZCDT(movexDate()); 
                            ZRBAS.WRITE("20"); 
                        } 
                    } break PBCHKX; 
                } break; 
            } while (true); // Sflnxtchg 
            PBCHK_ExecuteOption(); 
            if (DSP.WBRRNA != 0 && IN60) { 
                DSP.clearOption(); 
                DSP.updateSFL("BS"); 
            } 
            // Save fields for selected object in MVXLDA 
            if (!IN60 && !this.XXOPT2.isBlank()) { 
                // dummy then part 
            } 
        }
    

