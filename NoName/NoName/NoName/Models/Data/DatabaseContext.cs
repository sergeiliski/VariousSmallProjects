using NoName.Models.Data.Mapping;
using NoName.Models.Domain;
using System.Data.Entity;

namespace NoName.Models.Data {
    public class DatabaseContext : DbContext {
        public DatabaseContext()
            : base("Name=DatabaseContext") {
        }

        public DbSet<Show> Shows { get; set; }

        public DbSet<Episode> Episodes { get; set; }

        public DbSet<FAQ> FAQ { get; set; }

        public DbSet<NewsBulletin> NewsBulletins { get; set; }

        public DbSet<User> Users { get; set; }

        public DbSet<ShowSubscription> ShowSubscriptions { get; set; }

        public DbSet<ContactCategory> ContactCategories { get; set; }

        public DbSet<Message> Messages { get; set; }

        public DbSet<Genre> Genres { get; set; }

        public DbSet<ShowScore> ShowScores { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder) {
            modelBuilder.Configurations.Add(new ShowMap());
            modelBuilder.Configurations.Add(new EpisodeMap());
            modelBuilder.Configurations.Add(new FAQMap());
            modelBuilder.Configurations.Add(new NewsBulletinMap());
            modelBuilder.Configurations.Add(new UserMap());
            modelBuilder.Configurations.Add(new ShowSubscriptionMap());
            modelBuilder.Configurations.Add(new ContactCategoryMap());
            modelBuilder.Configurations.Add(new MessageMap());
            modelBuilder.Configurations.Add(new GenreMap());
            modelBuilder.Configurations.Add(new ShowScoreMap());
        }
    }
}