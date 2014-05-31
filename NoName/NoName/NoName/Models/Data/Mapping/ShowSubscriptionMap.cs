using NoName.Models.Domain;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class ShowSubscriptionMap : EntityTypeConfiguration<ShowSubscription> {
        public ShowSubscriptionMap() {
            HasKey(x => new { x.UserID, x.ShowID });
            ToTable("ShowSubsciptions");

            Property(x => x.ShowID)
                .IsRequired()
                .HasColumnName("ShowID");

            Property(x => x.UserID)
                .IsRequired()
                .HasColumnName("UserID");

            HasRequired(x => x.Show)
                .WithMany(x => x.ShowSubscriptions)
                .HasForeignKey(x => x.ShowID);

            HasRequired(x => x.User)
                .WithMany(x => x.ShowSubscriptions)
                .HasForeignKey(x => x.UserID);
        }
    }
}