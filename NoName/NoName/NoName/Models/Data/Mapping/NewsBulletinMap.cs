using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace NoName.Models.Data.Mapping {
    public class NewsBulletinMap : EntityTypeConfiguration<NewsBulletin> {
        public NewsBulletinMap() {
            ToTable("NewsBulletins");

            HasKey(x => x.ID);

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("ID");

            Property(x => x.Title)
                .IsRequired()
                .HasMaxLength(256)
                .HasColumnName("Title");

            Property(x => x.Introduction)
                .IsRequired()
                .HasMaxLength(1024)
                .HasColumnName("Introduction");

            Property(x => x.Body)
                .IsRequired()
                .HasMaxLength(32768)
                .HasColumnName("Body");

            Property(x => x.Timestamp)
                .IsRequired()
                .HasColumnName("Timestamp");
        }
    }
}