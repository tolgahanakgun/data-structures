using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace DataProjec3CShaRp
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            BSTUrun bst = new BSTUrun();

            Urun urun1 = new Urun();
            urun1.setUrunAdi("asdafsdasd");

            Urun urun2 = new Urun();
            urun2.setUrunAdi("sdafsdasd");

            Urun urun3 = new Urun();
            urun3.setUrunAdi("dafsdasd");

            bst.put(urun1);
            bst.put(urun2);
            bst.put(urun3);
            Console.WriteLine(bst.size());

            Console.WriteLine(bst.get("asdafsdasd").getUrunAdi());
            Console.WriteLine(bst.get("sdafsdasd").getUrunAdi());
            Console.WriteLine(bst.get("dafsdasd").getUrunAdi());


            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
