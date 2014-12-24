﻿using System;
using System.IO;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;

namespace DataProjec3CShaRp
{
    class UrunTXTReader
    {
        public UrunTXTReader() { }

        private string[][] reader(string txtFile)
        {
            char[] delimiterChars = { '~', ',' };
            string[][] geciciStrDizi = new string[100][];
            string[] strDizi = new string[8];
            int i = 0;
            TextReader reader = File.OpenText(txtFile);
            string gecici = reader.ReadLine();
            while ((gecici = reader.ReadLine()) != null)
            {
                strDizi = gecici.Split(delimiterChars);
                string[] str = strDizi[size(strDizi) - 1].ToString().Split(',');
                strDizi.Concat(str);
                geciciStrDizi[i] = strDizi;
                i++;
            }
            return geciciStrDizi;
        }

        private int size(string[] A)
        {
            int i = 0;
            try
            {
                while (A[i] != null) i++;
            }
            catch (IndexOutOfRangeException) { }
            return i;
        }

        public void fromTxtToTree(string txtFile, BSTUrun BSTree, Dictionary<string, List<Urun>> dt)
        {
            string[][] strDizi = reader(txtFile);
            Hasher hs = new Hasher();
            foreach (string[] str in strDizi)
            {
                if (str == null) break;

                Urun urun = new Urun();
                urun.setUrunAdi(str[0]);
                urun.setUrunKategori(str[1]);
                urun.setMarka(str[2]);
                urun.setModel(str[3]);
                urun.setMiktar(Convert.ToInt32(str[4]));
                urun.setMaliyet(Convert.ToInt32(str[5]));
                urun.setSatisFiyatı(Convert.ToInt32(str[6]));
                List<string> lst = new List<string>();
                int i = 7;
                string gecici;
                try
                {
                    while ((gecici = str[i]) != null)
                    {
                        lst.Add(gecici);
                        i++;
                    }
                }
                catch (IndexOutOfRangeException) { }
                hs.hasher(str, dt, urun);
                urun.setAciklama(lst);
                BSTree.put(urun);
            }
        }
    }
}
