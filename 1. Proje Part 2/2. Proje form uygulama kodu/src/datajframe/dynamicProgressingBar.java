package datajframe;

import javax.swing.SwingUtilities;

import org.eclipse.swt.widgets.ProgressBar;

public class dynamicProgressingBar implements Runnable {
    ProgressBar bar2;
    int bitis;
       public dynamicProgressingBar(ProgressBar bar, int bitis) {
           bar2 = bar;
           this.bitis = bitis;
       }

       public void run(){
           for(int i = 0 ; i <= bitis ; i++){
               final int percent = i;
               SwingUtilities.invokeLater(new Runnable() {
                   public void run() {
                       bar2.setSelection(percent);
                   }
                 });

               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {}
           }
       }
}