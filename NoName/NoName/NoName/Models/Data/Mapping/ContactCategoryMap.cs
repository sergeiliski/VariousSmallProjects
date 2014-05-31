using NoName.Models.Domain;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class ContactCategoryMap : EntityTypeConfiguration<ContactCategory> {
        public ContactCategoryMap() {
            HasKey(x => x.ID);
            ToTable("ContactCategories");

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("ID");

            Property(x => x.Category)
                .IsRequired()
                .HasMaxLength(256)
                .HasColumnName("Category");
        }
    }
}