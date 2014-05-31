using NoName.Models.Domain;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class EpisodeMap : EntityTypeConfiguration<Episode> {
        public EpisodeMap() {
            ToTable("Episodes");

            HasKey(x => x.EpisodeID);

            Property(x => x.EpisodeID)
            .IsRequired()
            .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
            .HasColumnName("EpisodeID");

            Property(x => x.ShowID)
                .IsRequired()
                .HasColumnName("ShowID");

            Property(x => x.EpisodeNumber)
                .IsRequired()
                .HasColumnName("EpisodeNumber");

            Property(x => x.Title)
                .IsOptional()
                .HasMaxLength(512)
                .HasColumnName("Title");

            Property(x => x.Description)
                .IsOptional()
                .HasMaxLength(1024)
                .HasColumnName("Description");

            Property(x => x.AirDate)
                .IsOptional()
                .HasColumnName("AirDate");

            Property(x => x.DownloadLink)
                .IsOptional()
                .HasMaxLength(512)
                .HasColumnName("DownloadLink");

            HasRequired(x => x.Show)
                .WithMany(x => x.Episodes)
                .HasForeignKey(x => x.ShowID);
        }
    }
}