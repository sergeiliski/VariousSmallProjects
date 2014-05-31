using NoName.Models.Domain;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Web;

namespace NoName.Models.Data.Mapping {
    public class FAQMap : EntityTypeConfiguration<FAQ> {
        public FAQMap() {
            ToTable("FAQ");
            HasKey(x => x.ID);

            Property(x => x.ID)
                .IsRequired()
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.Identity)
                .HasColumnName("ID");

            Property(x => x.Category)
                .IsRequired()
                .HasMaxLength(32)
                .HasColumnName("Category");

            Property(x => x.Question)
                .IsRequired()
                .HasMaxLength(512)
                .HasColumnName("Question");

            Property(x => x.Answer)
                .IsRequired()
                .HasMaxLength(4096)
                .HasColumnName("Answer");
        }
    }
}