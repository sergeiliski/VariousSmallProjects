using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace NoName.Models.Data.Mapping {
    public class UserMap : EntityTypeConfiguration<User> {
        public UserMap() {
            ToTable("Users");
            HasKey(x => x.ID);

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("ID");

            Property(x => x.Username)
                .IsRequired()
                .HasMaxLength(64)
                .HasColumnName("Username");

            Property(x => x.Email)
                .IsRequired()
                .HasMaxLength(128)
                .HasColumnName("Email");

            Property(x => x.RegistrationDate)
                .IsRequired()
                .HasColumnName("RegistrationDate");
        }
    }
}