namespace tesstt
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class book
    {
        public int Id { get; set; }

        [StringLength(50)]
        public string title { get; set; }

        [StringLength(50)]
        public string author { get; set; }

        public int? edition { get; set; }

        public decimal? price { get; set; }

        [StringLength(50)]
        public string image { get; set; }
    }
}
