using NoName.Models.Domain;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace NoName.Models.Data.Mapping {
    public class MessageMap : EntityTypeConfiguration<Message> {
        public MessageMap() {
            HasKey(x => x.ID);
            ToTable("Messages");

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("ID");

            Property(x => x.Date)
                .IsRequired()
                .HasColumnName("Date");

            Property(x => x.Email)
                .IsRequired()
                .HasMaxLength(128)
                .HasColumnName("Email");

            Property(x => x.Subject)
                .IsRequired()
                .HasMaxLength(256)
                .HasColumnName("Subject");

            Property(x => x.Body)
                .IsRequired()
                .HasMaxLength(4096)
                .HasColumnName("Message");

            Property(x => x.CategoryID)
                .IsRequired()
                .HasColumnName("CategoryID");

            Property(x => x.UserID)
                .IsOptional()
                .HasColumnName("UserID");

            HasRequired(x => x.Category)
                .WithMany()
                .HasForeignKey(x => x.CategoryID);

            HasOptional(x => x.Sender)
                .WithMany()
                .HasForeignKey(x => x.UserID);
        }
    }
}