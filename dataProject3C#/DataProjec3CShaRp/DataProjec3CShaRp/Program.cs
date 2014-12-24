using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Collections;

namespace DataProjec3CShaRp
{
    static class Global
    {
        private static BSTUrun bst = new BSTUrun();
        private static Heap heap = new Heap();

        public static BSTUrun BST
        {
            get { return bst; }
        }

        public static Heap HEAP
        {
            get { return heap; }
        }
    }

    static class Program
    {
        [STAThread]
        static void Main()
        {
            BSTUrun bst = new BSTUrun();
            MarkaModel mm = new MarkaModel();
            Urun urun1 = new Urun();

            

            

            /*Dictionary<string, List<Urun>> dt = new Dictionary<string, List<Urun>>();
            dt.Add("pc", urun1);
            dt.Add("bot", urun2);
            dt.Add("tel", urun3);

            Console.WriteLine(dt["pc"].getUrunAdi());*/

            //UrunTXTReader reader = new UrunTXTReader();
            //reader.fromTxtToTree("C:\\Users\\Çağrı\\Desktop\\urunler.txt", bst, dt);
            //Console.WriteLine(bst.get("Lenovo laptop").getUrunAdi());
           // Console.WriteLine(dt["i5"][0].ToString());
            //Console.WriteLine(dt["i5"][0].getUrunAdi());
            //Console.WriteLine(dt["i5"][1].getUrunAdi());
           // Console.WriteLine(bst.get("Lenovo laptop").getUrunAdi());
            //foreach (string str in reader.reader("C:\\Users\\TOLGAHAN\\Desktop\\urunler.txt")[0])
              //  Console.WriteLine(str);
            //reader("C:\\Users\\TOLGAHAN\\Desktop\\urunler.txt")[0]
            
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
            Application.Run(new Form2());    
        }
    }
}
