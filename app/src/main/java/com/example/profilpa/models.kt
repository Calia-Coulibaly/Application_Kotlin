package com.example.profilpa

//Liste des resultats
data class TmdbMovieResult(
    val page: Int = 0,
    val results: List<TmdbMovie> = listOf(),
    val total_pages:Int =0,
    val total_results:Int =0
)

// Liste des films populaires de la semaine
data class TmdbMovie(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

// Detail d'un film
data class TmdbMovieDetail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongs_to_collection: Any = Any(),
    val budget: Int = 0,
    val credits: Credits = Credits(),
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Credits(
    val cast: List<Cast> = listOf(),
    val crew: List<Crew> = listOf()
)

data class Genre(
    val id: Int = 0,
    val name: String = ""
)

data class ProductionCompany(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCountry(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class SpokenLanguage(
    val english_name: String = "",
    val iso_639_1: String = "",
    val name: String = ""
)

data class Cast(
    val adult: Boolean = false,
    val cast_id: Int = 0,
    val character: String = "",
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val name: String = "",
    val order: Int = 0,
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class Crew(
    val adult: Boolean = false,
    val credit_id: String = "",
    val department: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val job: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)


// Liste des series populaires de la semaine
data class TmdbTvResult(
    val page: Int = 0,
    val results: List<TmdbTv> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

// Liste d'une serie'

data class TmdbTv(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val first_air_date: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val name: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class TmdbActorResult(
    val page: Int = 0,
    val results: List<TmdbActor> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

// Liste des acteurs de la semaine
data class TmdbActor(
    val adult: Boolean = false,
    val gender: Int = 0,
    val id: Int = 0,
    val known_for: List<KnownFor> = listOf(),
    val known_for_department: String = "",
    val media_type: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

// Liste d'un acteur'
data class KnownFor(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)






