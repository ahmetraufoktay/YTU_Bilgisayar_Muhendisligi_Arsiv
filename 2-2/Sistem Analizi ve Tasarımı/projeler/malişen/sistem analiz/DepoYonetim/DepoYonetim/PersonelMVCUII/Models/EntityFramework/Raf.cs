//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace PersonelMVCUII.Models.EntityFramework
{
    using System;
    using System.Collections.Generic;
    
    public partial class Raf
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Raf()
        {
            this.UrunRafBilgisi = new HashSet<UrunRafBilgisi>();
        }
    
        public int Id { get; set; }
        public int KategoriId { get; set; }
        public Nullable<int> Kapasite { get; set; }
        public Nullable<int> AnlıkKapasite { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<UrunRafBilgisi> UrunRafBilgisi { get; set; }
        public virtual Kategori Kategori { get; set; }
    }
}
