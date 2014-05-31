using NoName.Models.Data.Repositories.Abstract;
using NoName.Models.Domain;
using System.Collections.Generic;
using System.Linq;

namespace NoName.Models.Data.Repositories.Concrete {
    public class GenreRepository : IGenreRepository {
        private DatabaseContext _db;

        public GenreRepository(DatabaseContext db) {
            _db = db;
        }

        public Genre GetGenreByID(int id) {
            return _db.Genres.FirstOrDefault(x => x.ID == id);
        }

        public Genre GetGenreByName(string name) {
            if (name == "Action" || name == "Adventure") {
                name = "Action and Adventure";
            }
            return _db.Genres.FirstOrDefault(x => x.Name == name);
        }

        public List<Genre> GetAllGenres() {
            return _db.Genres.ToList();
        }
    }
}