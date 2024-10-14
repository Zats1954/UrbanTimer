package ru.zatsoft.trainingsession

class Komplexes{val komplex = listOf(
    listOf(Exercise("Задний провал",R.drawable.back_dips,25),
        Exercise("Бицепсы",R.drawable.biceps_curl,35),
        Exercise("Отжимание",R.drawable.pushup,30),
        Exercise("Трицепсы",R.drawable.triceps,35)),
    listOf(
        Exercise("Приседания",R.drawable.prisedanie ,30),
        Exercise("Разножка лежа",R.drawable.raznozhka_lezha_na_zhivote,25),
        Exercise("Выпады вперед",R.drawable.vypady_vpered_malaja_amplituda,35)),
    listOf(
        Exercise("Крестовые повороты",R.drawable.crisscross,30),
        Exercise("Планка",R.drawable.plank,35,),
        Exercise("Боковая планка",R.drawable.side_plank,25))
)
}
