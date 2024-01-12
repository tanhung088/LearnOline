using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace OnlineShop_CoreMVC_TongHop.Models
{
	[Table("Product")]
	public class Product
	{
		[Key]
		[DatabaseGenerated(DatabaseGeneratedOption.Identity)]
		public int ? Pro_Id { get; set; }

		[Required(ErrorMessage = "Product Name Khong duoc bo trong!!!")]
		[StringLength(40,MinimumLength = 1 , ErrorMessage = "Product Name phai tu 1 den 40 ki tu")]
		[Display(Name = "Product Name")]
        public string ? Pro_Name { get; set; }

		[Required(ErrorMessage = "Product Description khong duoc bo trong")]
		[Display(Name = "Description")]
		public string ? Pro_Des { get; set; }

		[Required(ErrorMessage = "Unit Price khong duoc bo trong!!!")]
		[Range(1000, 10000, ErrorMessage = "Unit Price phai tu 1000 den 10000!!!")]
		[Display(Name = "UnitPrice")]
		public float ? UnitPrice{ get; set; }

		[Required(ErrorMessage = "Quantity khong duoc bo trong!!!")]
		[Display(Name = "Quantity")]
		public int ? Quantity { get; set; }

		[Required(ErrorMessage = "Hay nhap Discount!!! Neu khong discount nhap 0!")]
		[Range(0 , 100, ErrorMessage = "Discount phai tu 0 den 100!!!")]
		[Display(Name = "Discount")]
		public int ? Discount { get; set; }
    }
}
