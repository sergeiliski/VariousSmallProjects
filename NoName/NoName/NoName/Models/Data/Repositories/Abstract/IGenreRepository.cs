using NoName.Models.Domain;
using System.Collections.Generic;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface IGenreRepository {
        Genre GetGenreByID(int id);

        Genre GetGenreByName(string name);

        List<Genre> GetAllGenres();
    }
}