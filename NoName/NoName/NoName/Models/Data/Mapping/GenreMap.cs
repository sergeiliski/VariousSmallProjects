using NoName.Models.Domain;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class GenreMap : EntityTypeConfiguration<Genre> {
        public GenreMap() {
            HasKey(x => x.ID);
            ToTable("Genres");

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("GenreID");

            Property(x => x.Name)
                .IsRequired()
                .HasMaxLength(128)
                .HasColumnName("Name");

            HasMany(x => x.Shows)
                .WithMany(x => x.Genres)
                .Map(x => {
                    x.ToTable("ShowsWithGenres");
                    x.MapLeftKey("GenreID");
                    x.MapRightKey("ShowID");
                });
        }
    }
}