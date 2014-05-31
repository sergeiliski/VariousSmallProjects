using NoName.Models.Domain;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class ShowScoreMap : EntityTypeConfiguration<ShowScore> {
        public ShowScoreMap() {
            HasKey(x => new { x.ShowID, x.UserID });
            ToTable("ShowScores");

            Property(x => x.ShowID)
                .IsRequired()
                .HasColumnName("ShowID");

            Property(x => x.UserID)
                .IsRequired()
                .HasColumnName("UserID");

            Property(x => x.Score)
                .IsRequired()
                .HasColumnName("Score");

            //HasRequired(x => x.User)
            //    .WithOptional()
            //    .Map(x => x.MapKey("UserID"));

            //HasRequired(x => x.Show)
            //    .WithOptional()
            //    .Map(x => x.MapKey("ShowID"));
        }
    }
}