using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Collections;

namespace DataProjec3CShaRp
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            BSTUrun bst = new BSTUrun();

            Urun urun1 = new Urun();
            urun1.setUrunAdi("asdafsdasd");
            urun1.setSatisFiyatı(10);

            Urun urun2 = new Urun();
            urun2.setUrunAdi("sdafsdasd");
            urun2.setSatisFiyatı(100);

            Urun urun3 = new Urun();
            urun3.setUrunAdi("dafsdasd");
            urun3.setSatisFiyatı(1000);

            bst.put(urun1);
            bst.put(urun2);
            bst.put(urun3);
            Console.WriteLine(bst.size());
       
            Console.WriteLine(bst.get("asdafsdasd").getUrunAdi());
            Console.WriteLine(bst.get("sdafsdasd").getUrunAdi());
            Console.WriteLine(bst.get("dafsdasd").getUrunAdi());

            Console.WriteLine(bst.size(bst.get("dafsdasd")));

            Urun urun4 = new Urun();
            urun4.setSatisFiyatı(1001);

            Urun urun5 = new Urun();
            urun5.setSatisFiyatı(1002);

            Urun urun6 = new Urun();
            urun6.setSatisFiyatı(1003);

            Heap hp = new Heap();
            hp.insert(urun1);
            hp.insert(urun2);
            hp.insert(urun3);
            hp.insert(urun4);
            hp.insert(urun5);
            hp.insert(urun6);
            Console.WriteLine(hp.removeMin().getSatisFiyatı());
            Console.WriteLine(hp.removeMin().getSatisFiyatı());
            Console.WriteLine(hp.removeMin().getSatisFiyatı());
            Console.WriteLine(hp.removeMin().getSatisFiyatı());
            Console.WriteLine(hp.removeMin().getSatisFiyatı());
            Console.WriteLine(hp.removeMin().getSatisFiyatı());


            Dictionary<string, Urun> dt = new Dictionary<string,Urun>();
            dt.Add("pc", urun1);
            dt.Add("bot", urun2);
            dt.Add("tel", urun3);


            Console.WriteLine(dt["pc"].getUrunAdi());


                Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
