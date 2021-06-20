project("Bit Contents")

add_executable(
    test
    main.cc)

target_include_directories(
    test
    PUBLIC
      .)

target_compile_features(
    test
    PUBLIC
      cxx_std_14)
