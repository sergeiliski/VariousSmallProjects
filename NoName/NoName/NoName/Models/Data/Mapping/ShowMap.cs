using NoName.Models.Domain;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class ShowMap : EntityTypeConfiguration<Show> {
        public ShowMap() {
            ToTable("Shows");

            HasKey(x => x.ShowID);

            Property(x => x.ShowID)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .IsRequired()
                .HasColumnName("ShowID");

            Property(x => x.Title)
                .IsRequired()
                .HasMaxLength(256)
                .HasColumnName("Title");

            Property(x => x.Description)
                .HasMaxLength(1024)
                .IsRequired()
                .HasColumnName("Description");

            Property(x => x.StartDate)
                .IsRequired()
                .HasColumnName("StartDate");

            Property(x => x.EndDate)
                .IsOptional()
                .HasColumnName("EndDate");

            Property(x => x.IMDb)
                .IsOptional()
                .HasMaxLength(128)
                .HasColumnName("IMDb");

            Property(x => x.EZTV)
                .IsOptional()
                .HasMaxLength(128)
                .HasColumnName("EZTV");

            Property(x => x.EZTVID)
                .IsOptional()
                .HasColumnName("EZTVID");

            Property(x => x.TVDBID)
                .IsOptional()
                .HasColumnName("TVDBID");

            Property(x => x.LastUpdated)
                .IsOptional()
                .HasColumnName("LastUpdate");

            Property(x => x.Poster)
                .IsOptional()
                .HasColumnName("Poster");
        }
    }
}