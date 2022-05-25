package nextstep.subway.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.subway.domain.Line;
import nextstep.subway.domain.LineRepository;
import nextstep.subway.domain.Station;
import nextstep.subway.domain.StationRepository;
import nextstep.subway.dto.LineRequestDTO;
import nextstep.subway.dto.LineResponseDTO;
import nextstep.subway.dto.LineResponsesDTO;
import nextstep.subway.dto.StationResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import({LineService.class, StationService.class})
class LineServiceTest {

    @Autowired
    private LineService lineService;
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private StationRepository stationRepository;

    @DisplayName("연결된 지하철역이 있는 노선을 생성한다.")
    @Test
    void saveLine() {
        //given
        Station pangyo = stationRepository.save(new Station("판교"));
        Station jeongja = stationRepository.save(new Station("정자"));
        LineRequestDTO lineRequestDTO = new LineRequestDTO("신분당선", "bg-red-600", 1L, 2L, 10L);

        //when
        LineResponseDTO lineResponseDTO = lineService.saveLine(lineRequestDTO);

        //then
        assertThat(lineResponseDTO.getName()).isEqualTo("신분당선");
        assertThat(lineResponseDTO.getColor()).isEqualTo("bg-red-600");

        List<StationResponseDTO> stations = lineResponseDTO.getStations();
        assertThat(stations.get(0).getId()).isEqualTo(pangyo.getId());
        assertThat(stations.get(0).getName()).isEqualTo(pangyo.getName());
        assertThat(stations.get(1).getId()).isEqualTo(jeongja.getId());
        assertThat(stations.get(1).getName()).isEqualTo(jeongja.getName());
    }

    @DisplayName("노선 전체 목록을 조회한다.")
    @Test
    void findAll() {
        //given
        lineRepository.save(new Line("신분당선", "bg-red-600"));
        lineRepository.save(new Line("분당선", "bg-yellow-600"));

        //when
        LineResponsesDTO lineResponsesDTO = lineService.findAll();

        //then
        assertThat(lineResponsesDTO.getLineResponses()).hasSize(2);
    }
}
