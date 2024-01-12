namespace OnlineShop_MVC_tedu
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("user")]
    public partial class user
    {
        [Key]
        public int user_id { get; set; }

        [StringLength(150)]
        public string user_name { get; set; }

        [StringLength(150)]
        public string email { get; set; }

        [StringLength(150)]
        public string password { get; set; }
    }
}
