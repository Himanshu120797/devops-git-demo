package mvx.app.pgm.customer;

import mvx.app.pgm.common.*;
import mvx.dsp.common.GenericDSP;
import mvx.dsp.common.interactive;
import mvx.dsp.obj.*;
import mvx.util.*;

public class ZMS304 extends Interactive {
    /** PBINZ - Init */
    public void PBINZ() {
        // - Position cursor
        DSP.setFocus(6, 6, "W1CUNO");

        // - Init of subfile information switch (0)
        if (IN61) {
            XXCUNO.move(DSP.W1CUNO);
            XXPRRF.move(DSP.W1PRRF);
            XXITNO.move(DSP.W1ITNO);
        } else if (IN62) {
            XX00YN.move(DSP.W200YN);
            XXCUNO.move(DSP.W2CUNO);
            XXPRRF.move(DSP.W2PRRF);
            XXITNO.move(DSP.W2ITNO);
        } else if (IN63) {
            XXUSID.move(DSP.W3USID);
            XXCUNO.move(DSP.W3CUNO);
            XXPRRF.move(DSP.W3PRRF);
            XXITNO.move(DSP.W3ITNO);
        } else if (IN64) {
            X4RGDT = DSP.W4RGDT;
            X4RGTM = DSP.W4RGTM;
            XXUSID.move(DSP.W4USID);
            XXCUNO.move(DSP.W4CUNO);
            XXPRRF.move(DSP.W4PRRF);
            XXITNO.move(DSP.W4ITNO);
        } else if (IN65) {
            X5RGDT = DSP.W5RGDT;
            XX00YN.move(DSP.W500YN);
            XXUSID.move(DSP.W5USID);
            XXCUNO.move(DSP.W5CUNO);
            XXPRRF.move(DSP.W5PRRF);
            XXITNO.move(DSP.W5ITNO);
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
        //A BSLTRM00420 250529 
        ZQBAS.setCHID().move(DSP.W3USID); 
        //A BSLTRM00420 250529 
        ZQBAS.setCUNO().move(DSP.W3CUNO); 
        //A BSLTRM00420 250529 
        ZQBAS.setPRRF().move(DSP.W3PRRF); 
        //A BSLTRM00420 250529 
        ZQBAS.setITNO().move(DSP.W3ITNO); 
        //A BSLTRM00420 250529 
        ZQBAS.SETLL_SCAN("50", ZQBAS.getKey("50")); 
    } //A BSLTRM00420 250529 
    // - Question type 4 
    //A BSLTRM00420 250603 
    if (IN64) { 
        ZQBAS.setRGDT(DSP.W4RGDT); 
        ZQBAS.setRGTM(DSP.W4RGTM); 
        ZQBAS.setCHID().move(DSP.W4USID); 
        ZQBAS.setCUNO().move(DSP.W4CUNO); 
        //A BSLTRM00420 250529 
        ZQBAS.setPRRF().move(DSP.W4PRRF); 
        //A BSLTRM00420 250529 
        ZQBAS.setITNO().move(DSP.W4ITNO); 
        //A 
        ZQBAS.SETLL_SCAN("60", ZQBAS.getKey("60")); 
    } //A BSLTRM00420 250529 
    // - Question type 5 
    //A BSLTRM00420 250603 
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

}
