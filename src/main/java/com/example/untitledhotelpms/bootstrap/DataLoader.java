package com.example.untitledhotelpms.bootstrap;

import com.example.untitledhotelpms.domain.AppUser;
import com.example.untitledhotelpms.domain.Room;
import com.example.untitledhotelpms.domain.RoomType;
import com.example.untitledhotelpms.domain.UserRole;
import com.example.untitledhotelpms.service.AppUserService;
import com.example.untitledhotelpms.service.RoomService;
import com.example.untitledhotelpms.service.RoomTypeService;
import com.example.untitledhotelpms.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppUserService appUserService;
    private final UserRoleService userRoleService;
    private final RoomTypeService roomTypeService;
    private final RoomService roomService;

    public DataLoader(AppUserService appUserService, UserRoleService userRoleService, RoomTypeService roomTypeService, RoomService roomService) {
        this.appUserService = appUserService;
        this.userRoleService = userRoleService;
        this.roomTypeService = roomTypeService;
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = appUserService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        UserRole admin = UserRole.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("ADMIN")
                .build();

        userRoleService.save(admin);
        System.out.println("Created UserRole: " + admin.getName());

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(admin);

        AppUser user1 = AppUser.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .firstName("Jerry")
                .lastName("Fallwell")
                .email("jf@gmail.com")
                .phone("4175555555")
                .address1("123 Easy St")
                .address2("")
                .city("Anytown")
                .state("Indiana")
                .country("United States")
                .postalCode("75486")
                .userRoles(userRoles)
                .build();

        appUserService.save(user1);
        System.out.println("Created AppUser: " + user1.getFirstName());

        RoomType doubleQueen = RoomType.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("Double Queen")
                .description("Two Queen Sized Beds")
                .kingBeds(0L)
                .queenBeds(2L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(0L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(false)
                .handicapAccessible(false)
                .smoking(false)
                .build();

        RoomType singleKing = RoomType.builder()
                .id(2L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("Single King")
                .description("One King Sized Bed")
                .kingBeds(1L)
                .queenBeds(0L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(0L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(false)
                .handicapAccessible(false)
                .smoking(false)
                .build();

        RoomType kingSuite = RoomType.builder()
                .id(3L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("King Suite")
                .description("One King Sized Bed and Sofa Sleeper")
                .kingBeds(1L)
                .queenBeds(0L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(1L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(true)
                .handicapAccessible(true)
                .smoking(false)
                .build();

        roomTypeService.save(doubleQueen);
        System.out.println("Created RoomType: " + doubleQueen.getName());
        roomTypeService.save(singleKing);
        System.out.println("Created RoomType: " + singleKing.getName());
        roomTypeService.save(kingSuite);
        System.out.println("Created RoomType: " + kingSuite.getName());

        Room room101 = Room.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("101")
                .description("King Suite")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room101.setRoomType(kingSuite);

        Room room102 = Room.builder()
                .id(2L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("102")
                .description("Single K")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room102.setRoomType(singleKing);

        Room room103 = Room.builder()
                .id(3L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("103")
                .description("King Suite")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room103.setRoomType(kingSuite);

        Room room104 = Room.builder()
                .id(4L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("104")
                .description("Single  K")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room104.setRoomType(singleKing);

        Room room105 = Room.builder()
                .id(5L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("105")
                .description("Conjoined QQ")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room105.setRoomType(doubleQueen);

        Room room106 = Room.builder()
                .id(6L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("106")
                .description("Conjoined QQ")
                .vacant(true)
                .clean(true)
                .underMaintenance(false)
                .build();
        room106.setRoomType(doubleQueen);

//        Set<Room> conjoinedRooms = new HashSet<>();
//        conjoinedRooms.add(room106);
//        room105.setConjoinedWith(conjoinedRooms);
//        Set<Room> alsoConjoinedRooms = new HashSet<>();
//        alsoConjoinedRooms.add(room105);
//        room106.setConjoinedWith(alsoConjoinedRooms);

        roomService.save(room101);
        System.out.println("Created Room: " + room101.getName());
        roomService.save(room102);
        System.out.println("Created Room: " + room102.getName());
        roomService.save(room103);
        System.out.println("Created Room: " + room103.getName());
        roomService.save(room104);
        System.out.println("Created Room: " + room104.getName());
        roomService.save(room105);
        System.out.println("Created Room: " + room105.getName());
        roomService.save(room106);
        System.out.println("Created Room: " + room106.getName());
    }
}
