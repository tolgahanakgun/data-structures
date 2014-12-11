using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DataProjec3CShaRp
{

    public class BSTUrun
    {
        private Urun root;

        // ağaç boş mu ?
        public bool isEmpty()
        {
            return size() == 0;
        }

        // ağaçtaki düğüm sayısını döndürür
        public int size()
        {
            return size(root);
        }

        // x düğümünün altındaki düğüm sayısını döndürür
        private int size(Urun x)
        {
            if (x == null) return 0;
            else return x.getN();
        }

        /***********************************************************************
         *  Search BST for given key, and return associated value if found,
         *  return null if not found
         ***********************************************************************/

        // bu isme sahip ürün var mı?
        public bool contains(String urunAdi)
        {
            return get(urunAdi) != null;
        }

        // ismi verilen ürünü döndürür yoksa null döndürür
        public Urun get(String urunAdi)
        {
            return get(root, urunAdi);
        }

        private Urun get(Urun x, String urunAdi)
        {
            if (x == null) return null;
            //int cmp = urunAdi.compareTo(x.getUrunAdi());
            int cmp = String.Compare(urunAdi, x.getUrunAdi());
            if (cmp < 0) return get(x.getLeft(), urunAdi);
            else if (cmp > 0) return get(x.getRight(), urunAdi);
            else return x;
        }

        /***********************************************************************
         *  Ağaca yeni düğüm ekleme
         *  Eğer eklenecek düğüm zaten ağaçta mevcut ise bilgileri güncellenir
         ***********************************************************************/

        public void put(Urun eklenecekUrun)
        {
            // if (val == null) { delete(key); return; }
            root = put(root, eklenecekUrun);
            //assert check();
        }

        private Urun put(Urun root, Urun eklenecekUrun)
        {
            if (root == null) return eklenecekUrun;
            //int cmp = eklenecekUrun.getUrunAdi().compareTo(root.getUrunAdi());
            int cmp = string.Compare(eklenecekUrun.getUrunAdi(), root.getUrunAdi());
            if (cmp < 0) root.setLeft(put(root.getLeft(), eklenecekUrun));
            else if (cmp > 0) root.setRight(put(root.getRight(), eklenecekUrun));
            else root = eklenecekUrun;
            root.setN(1 + size(root.getLeft()) + size(root.getRight()));
            return root;
        }

        /***********************************************************************
         *  Silme
         ***********************************************************************/
        public void deleteMin()
        {
            if (isEmpty()) throw new NullReferenceException("Symbol table underflow");
            root = deleteMin(root);
            //assert check();
        }

        private Urun deleteMin(Urun silinecekUrun)
        {
            if (silinecekUrun.getLeft() == null) return silinecekUrun.getRight();
            silinecekUrun.setLeft(deleteMin(silinecekUrun.getLeft()));
            silinecekUrun.setN(size(silinecekUrun.getLeft()) + size(silinecekUrun.getRight()) + 1);
            return silinecekUrun;
        }

        public void deleteMax()
        {
            if (isEmpty()) throw new NullReferenceException("Symbol table underflow");
            root = deleteMax(root);
            //assert check();
        }

        private Urun deleteMax(Urun silinecekUrun)
        {
            if (silinecekUrun.getRight() == null) return silinecekUrun.getLeft();
            silinecekUrun.setRight(deleteMax(silinecekUrun.getRight()));
            silinecekUrun.setN(size(silinecekUrun.getLeft()) + size(silinecekUrun.getRight()) + 1);
            return silinecekUrun;
        }

        public void delete(String urunAdi)
        {
            root = delete(root, urunAdi);
            //assert check();
        }

        private Urun delete(Urun root, String urunAdi)
        {
            if (root == null) return null;
            //int cmp = urunAdi.compareTo(root.getUrunAdi());
            int cmp = string.Compare(urunAdi, root.getUrunAdi());
            if (cmp < 0) root.setLeft(delete(root.getLeft(), urunAdi));
            else if (cmp > 0) root.setRight(delete(root.getRight(), urunAdi));
            else
            {
                if (root.getRight() == null) return root.getLeft();
                if (root.getLeft() == null) return root.getRight();
                Urun t = root;
                root = min(root.getRight());
                root.setRight(deleteMin(t.getRight()));
                root.setLeft(t.getLeft());
            }
            root.setN(size(root.getLeft()) + size(root.getRight()) + 1);
            return root;
        }

        /***********************************************************************
         *  Min, max, floor, and ceiling
         ***********************************************************************/
        public String min()
        {
            if (isEmpty()) return null;
            return min(root).getUrunAdi();
        }

        private Urun min(Urun x)
        {
            if (x.getLeft() == null) return x;
            else return min(x.getLeft());
        }

        public String max()
        {
            if (isEmpty()) return null;
            return max(root).getUrunAdi();
        }

        private Urun max(Urun x)
        {
            if (x.getRight() == null) return x;
            else return max(x.getRight());
        }

        public String floor(String urunAdi)
        {
            Urun x = floor(root, urunAdi);
            if (x == null) return null;
            else return x.getUrunAdi();
        }

        private Urun floor(Urun x, String urunAdi)
        {
            if (x == null) return null;
            //int cmp = urunAdi.compareTo(x.getUrunAdi());
            int cmp = string.Compare(urunAdi, x.getUrunAdi());
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.getLeft(), urunAdi);
            Urun t = floor(x.getRight(), urunAdi);
            if (t != null) return t;
            else return x;
        }

        public String ceiling(String urunAdi)
        {
            Urun x = ceiling(root, urunAdi);
            if (x == null) return null;
            else return x.getUrunAdi();
        }

        private Urun ceiling(Urun x, String urunAdi)
        {
            if (x == null) return null;
            //int cmp = urunAdi.compareTo(x.getUrunAdi());
            int cmp = string.Compare(urunAdi, x.getUrunAdi());
            if (cmp == 0) return x;
            if (cmp < 0)
            {
                Urun t = ceiling(x.getLeft(), urunAdi);
                if (t != null) return t;
                else return x;
            }
            return ceiling(x.getRight(), urunAdi);
        }

        /***********************************************************************
         *  Rank and selection
         ***********************************************************************/
        public String select(int k)
        {
            if (k < 0 || k >= size()) return null;
            Urun x = select(root, k);
            return x.getUrunAdi();
        }

        // Return key of rank k. 
        private Urun select(Urun x, int k)
        {
            if (x == null) return null;
            int t = size(x.getLeft());
            if (t > k) return select(x.getLeft(), k);
            else if (t < k) return select(x.getRight(), k - t - 1);
            else return x;
        }

        public int rank(String key)
        {
            return rank(key, root);
        }

        // Number of keys in the subtree less than key.
        private int rank(String key, Urun x)
        {
            if (x == null) return 0;
            //int cmp = key.compareTo(x.getUrunAdi()); 
            int cmp = string.Compare(key, x.getUrunAdi());
            if (cmp < 0) return rank(key, x.getLeft());
            else if (cmp > 0) return 1 + size(x.getLeft()) + rank(key, x.getRight());
            else return size(x.getLeft());
        }

        /***********************************************************************
         *  Range count and range search.
         ***********************************************************************/
        public IEnumerator<String> keys()
        {
            return keys(min(), max());
        }

        public IEnumerator<String> keys(String lo, String hi)
        {
            Queue<String> queue = new Queue<String>();
            keys(root, queue, lo, hi);
            return (IEnumerator<String>)queue;
        }


        private void keys(Urun x, Queue<String> queue, String lo, String hi)
        {
            if (x == null) return;
            //int cmplo = lo.compareTo(x.getUrunAdi()); 
            //int cmphi = hi.compareTo(x.getUrunAdi()); 
            int cmplo = string.Compare(lo, x.getUrunAdi());
            int cmphi = string.Compare(hi, x.getUrunAdi());
            if (cmplo < 0) keys(x.getLeft(), queue, lo, hi);
            if (cmplo <= 0 && cmphi >= 0) queue.Enqueue(x.getUrunAdi());
            if (cmphi > 0) keys(x.getRight(), queue, lo, hi);
        }


        public int size(String lo, String hi)
        {
            if (string.Compare(lo, hi) > 0) return 0;
            if (contains(hi)) return rank(hi) - rank(lo) + 1;
            else return rank(hi) - rank(lo);
        }


        // height of this BST (one-node tree has height 0)
        public int height() { return height(root); }
        private int height(Urun x)
        {
            if (x == null) return -1;
            return 1 + Math.Max(height(x.getLeft()), height(x.getRight()));
        }


        // level order traversal
        public IEnumerator<String> levelOrder()
        {
            Queue<String> keys = new Queue<String>();
            Queue<Urun> queue = new Queue<Urun>();
            queue.Enqueue(root);
            while (queue.Count != 0)
            {
                Urun x = queue.Dequeue();
                if (x == null) continue;
                keys.Enqueue(x.getUrunAdi());
                queue.Enqueue(x.getLeft());
                queue.Enqueue(x.getRight());
            }
            return (IEnumerator<String>)keys;
        }

    }

}

