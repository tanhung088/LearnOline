using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DemoCore_MVC.Models
{
    [Table("Employee")]
    public class Employee
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Emp_id { get; set; }

        [Required(ErrorMessage = "Employee Name khong duoc bo trong")]
        [StringLength(40, MinimumLength = 2, ErrorMessage = "Emp Name tu 2 den 40 ki tu")]
        public string ? Emp_name { get; set; }

        [Required(ErrorMessage = "Phone khong duoc bo trong")]
        [Display(Name = "Phone")]
        public string ? Phone { get; set; }

        [Required(ErrorMessage = "Skill khong duoc bo trong")]
        public string ? Skills { get; set; }

        [Required(ErrorMessage = "Ex khong duoc bo trong")]
        [Range(1,10, ErrorMessage = "Ex tu 1 den 10")]
        public int ? Experiences { get; set; }
    }
}
