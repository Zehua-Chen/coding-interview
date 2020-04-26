project("Buddy Tree")

add_executable(
    test
		main.cc
		tree.cc)

target_include_directories(
    test
    PUBLIC
      .)

target_compile_features(
    test
    PUBLIC
      cxx_std_14)
