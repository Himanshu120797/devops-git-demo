package mvx.app.pgm.customer;   
import mvx.app.pgm.common.*;
import mvx.dsp.common.GenericDSP;
import mvx.dsp.common.interactive;
import mvx.dsp.obj.*;
import mvx.util.*;


public class ZMS304 extends interactive
{
    public void PBINZ()
    {
        // This is the main entry point for the ZMS304 program.
        // It will handle the interactive processing logic.
        
        // Initialize the DSP (Data Service Provider) for this program.
        GenericDSP dsp = new GenericDSP();
        
        // Perform any necessary setup or initialization here.
        dsp.initialize();

        // Call the main processing method of the DSP.
        dsp.process();

        // Finalize or clean up resources if needed.
        dsp.finalize();
    }
    
}
