using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Reflection.Metadata.Ecma335;

namespace OnlineShop_CoreMVC_TongHop.Models
{
	[Table("User")]
	public class User
	{
		[Key]
		[DatabaseGenerated(DatabaseGeneratedOption.Identity)]
		public int ? User_Id { get; set; }

		[Required(ErrorMessage = "USer Name Khong duoc bo trong!!!")]
		[StringLength(50, ErrorMessage = "User Name chi duoc toi da 50 ki tu")]
		public string ? User_Name { get; set; }

		[Required(ErrorMessage = "Email khong duoc bo trong!!!")]
		[EmailAddress(ErrorMessage = "Email chua dung dinh dang!!!")]
		[StringLength(150)]
		public string ? Email { get; set; }

		[Required(ErrorMessage = "Password khong duoc bo trong!!!")]
		[StringLength(150)]
		public string ? Password { get; set; }

        [Required(ErrorMessage = "Phone khong duoc bo trong!!!")]
		[Display(Name = "Phone")]
        public string ? Phone { get; set; }

        public string ? Avatar { get; set; }


        [DefaultValue(false)]
		public bool ? Role { get; set; }
	}
}
