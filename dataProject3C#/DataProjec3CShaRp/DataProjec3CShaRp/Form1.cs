using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Collections;

namespace DataProjec3CShaRp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        BSTUrun bst = Global.BST;
        Heap heap = Global.HEAP;

        int satilanTop = 0;
        int satilanMaliyet = 0;

        private void btn_YeniEkle_Click(object sender, EventArgs e)
        {
            if (txt_Dosya.Text != "")
            {
                Dictionary<string, List<Urun>> dt = new Dictionary<string, List<Urun>>();

                UrunTXTReader reader = new UrunTXTReader();
                try
                {
                    reader.fromTxtToTree(txt_Dosya.Text, bst, dt);
                    MessageBox.Show("Ürünler başarıyla eklendi.");
                }
                catch (FileNotFoundException ex)
                {
                    Console.WriteLine("[Data File Missing] {0}", ex);
                    throw new FileNotFoundException(@"[urunler.txt not in c:\temp directory]", ex);
                }

            }
            else
            {
                Dictionary<string, List<Urun>> dt = new Dictionary<string, List<Urun>>();
                char[] delimiterChars = {'\'', ','};
 
                Urun urun = new Urun();

                urun.setUrunAdi(txt_UrunAdi.Text);
                urun.setUrunKategori(txt_UrunKategori.Text);
                urun.setMarka(txt_UrunMarka.Text);
                urun.setModel(txt_UrunModel.Text);
                urun.setMiktar(Convert.ToInt32(txt_UrunMiktar.Text));
                urun.setMaliyet(Convert.ToInt32(txt_UrunMaliyet.Text));
                urun.setSatisFiyatı(Convert.ToInt32(txt_UrunSatisFiyati.Text));

                string[] words = txt_UrunAciklama.Text.Split(delimiterChars);
                List<string> lst = new List<string>();
                foreach (string str in words)
                {
                    if (str == null) break;
                    
                    lst.Add(str);

                    if (!dt.ContainsKey(str))
                    {
                        List<Urun> hList = new List<Urun>();
                        hList.Add(urun);
                        dt.Add(str, hList);
                    }
                    else
                        dt[str].Add(urun);
                }
                urun.setAciklama(lst);
                bst.put(urun);
                MessageBox.Show(txt_UrunAdi.Text + " ürünü başarıyla eklendi.");
                temizle();
            }
        }

        OpenFileDialog ofd = new OpenFileDialog();

        private void btn_DosyaSec_Click(object sender, EventArgs e)
        {
            ofd.Filter = "Text Files (*.txt)|*.txt";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                //System.IO.FileInfo File = new System.IO.FileInfo(ofd.FileName);
                txt_Dosya.Text = ofd.FileName;
            }
        }

        private void txt_Dosya_TextChanged(object sender, EventArgs e)
        {
            if (txt_Dosya.Text != "")
            {
                grpBox_UrunEkle.Enabled = false;
            }
            else
                grpBox_UrunEkle.Enabled = true;
        }

        public void temizle()
        {
            txt_UrunAdi.Clear();
            txt_UrunAciklama.Clear();
            txt_UrunKategori.Clear();
            txt_UrunMaliyet.Clear();
            txt_UrunMarka.Clear();
            txt_UrunMiktar.Clear();
            txt_UrunModel.Clear();
            txt_UrunSatisFiyati.Clear();
        }

        private void btn_UrunAra_Click(object sender, EventArgs e)
        {
            lstView_UrunSil.Items.Clear();

            if (txt_UrunAdiAra.Text != "")
            {
                if (bst.contains(txt_UrunAdiAra.Text))
                {
                    Urun urun = new Urun();

                    urun = bst.get(txt_UrunAdiAra.Text);
                    
                    ListViewItem lvi = new ListViewItem(urun.getUrunAdi());

                    lvi.SubItems.Add(urun.getUrunKategori());
                    lvi.SubItems.Add(urun.getMarka());
                    lvi.SubItems.Add(urun.getModel());
                    lvi.SubItems.Add(urun.getMiktar().ToString());
                    lvi.SubItems.Add(urun.getMaliyet().ToString());
                    lvi.SubItems.Add(urun.getSatisFiyatı().ToString());

                    string[] aciklamaDizi = urun.getAciklama().ToArray();

                    lvi.SubItems.Add(string.Join(",",aciklamaDizi));

                    lstView_UrunSil.Items.Add(lvi);

                    //lstView_UrunSil.AutoResizeColumn(ColumnHeaderAutoResizeStyle.HeaderSize);
                }
                else
                    MessageBox.Show("Aranan ürün bulunamadı.");
            }
            else
                MessageBox.Show("Lütfen aranacak ürünün adını giriniz!");
        }

        private void txt_UrunMiktar_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar != 8 && !Char.IsDigit(e.KeyChar))
                e.Handled = true;
        }

        private void txt_UrunMaliyet_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar))
                e.Handled = true;
        }

        private void txt_UrunSatisFiyati_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar != 8 && !Char.IsDigit(e.KeyChar))
                e.Handled = true;
        }

        private void btn_UrunSil_Click(object sender, EventArgs e)
        {
            try
            {
                string silinen = lstView_UrunSil.SelectedItems[0].SubItems[0].Text;
                bst.delete(silinen);
                MessageBox.Show(silinen + " ürünü silindi.");
                lstView_UrunSil.Items.Clear();
            }
            catch (Exception)
            {
                MessageBox.Show("Beklenmeyen bir sorunla karşılaşıldı ve ürün silinemedi","Hata",MessageBoxButtons.OK,MessageBoxIcon.Error);
            }            
        }

        private void btn_UrunGuncelle_Click(object sender, EventArgs e)
        {
            if (txt_GuncelUrunAdi.Text != "")
            {
                if (bst.contains(txt_GuncelUrunAdi.Text))
                {
                    Dictionary<string, List<Urun>> dt = new Dictionary<string, List<Urun>>();
                    char[] delimiterChars = { '~', ',' };

                    Urun urun = new Urun();

                    urun = bst.get(txt_GuncelUrunAdi.Text);

                    urun.setUrunKategori(txt_GuncelUrunKategori.Text);
                    urun.setMarka(txt_GuncelUrunMarka.Text);
                    urun.setModel(txt_GuncelUrunModel.Text);
                    urun.setMiktar(Convert.ToInt32(txt_GuncelUrunMiktar.Text));
                    urun.setMaliyet(Convert.ToInt32(txt_GuncelUrunMaliyet.Text));
                    urun.setSatisFiyatı(Convert.ToInt32(txt_GuncelUrunSatisFiyati.Text));

                    string[] words = txt_UrunAciklama.Text.Split(delimiterChars);
                    List<string> lst = new List<string>();
                    foreach (string str in words)
                    {
                        if (str == null) break;

                        lst.Add(str);

                        if (!dt.ContainsKey(str))
                        {
                            List<Urun> hList = new List<Urun>();
                            hList.Add(urun);
                            dt.Add(str, hList);
                        }

                        else
                            dt[str].Add(urun);
                    }
                    urun.setAciklama(lst);
                    MessageBox.Show(txt_GuncelUrunAdi.Text + " ürünü başarıyla güncellendi.");
                }
                else
                    MessageBox.Show("Girilen isimde ürün bulunamadı.");
            }
            else
                MessageBox.Show("Güncellenecek ürünün adını giriniz.");
        }

        private void btn_Sat_Click(object sender, EventArgs e)
        {
            string satilacak = lstView_UrunSil.SelectedItems[0].SubItems[0].Text;
            int adet = Convert.ToInt32(txt_SatilanUrunAdet.Text);

            Urun urun = new Urun();

            urun = bst.get(satilacak);
            int kalanMiktar = urun.getMiktar() - adet;
            urun.setMiktar(kalanMiktar);

            satilanTop += Convert.ToInt32(lstView_UrunSil.SelectedItems[0].SubItems[6].Text)*adet;
            satilanMaliyet += Convert.ToInt32(lstView_UrunSil.SelectedItems[0].SubItems[5].Text)*adet;

            MessageBox.Show(adet + " adet " + urun.getUrunAdi() + " ürünü satıldı.");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            txt_Gelir.Text = satilanTop.ToString();
            txt_Gider.Text = satilanMaliyet.ToString();
            txt_Kar.Text = (satilanTop - satilanMaliyet).ToString();
        }

        private void btn_Guncelle_Click(object sender, EventArgs e)
        {
            txt_Gelir.Text = satilanTop.ToString();
            txt_Gider.Text = satilanMaliyet.ToString();
            txt_Kar.Text = (satilanTop - satilanMaliyet).ToString();
        }
    }
}
