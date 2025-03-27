import java.util.*;

public class ObjectMethod {

    public static class SampleDataDto {


        private String title;
        private String content;
        private int id;

        public SampleDataDto(String title, String content, int id) {
            this.title = title;
            this.content = content;
            this.id = id;
        }

        public String getTitle(){
            return this.title;
        }

        public String getContent(){
            return this.content;
        }

        public int getId(){
            return this.id;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            SampleDataDto sampleDataDto = (SampleDataDto) obj;
            return Objects.equals(title, sampleDataDto.getTitle()) && Objects.equals(content, sampleDataDto.getContent()) && this.id == sampleDataDto.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, content, id);
        }
    }

    public static void main(String[] args) {

        List<SampleDataDto> sampleDataDtoList1 = new ArrayList<>();
        List<SampleDataDto> sampleDataDtoList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sampleDataDtoList1.add(new SampleDataDto("SampleDataDto" + i, "Content" + i, i));
        }
        for(int i = 0; i < 11; i++){
            sampleDataDtoList2.add(new SampleDataDto("SampleDataDto" + i, "Content" + i, i));
        }

        Set<SampleDataDto> sampleDataDtoSet = new HashSet<>(sampleDataDtoList1);

        sampleDataDtoList2.removeAll(sampleDataDtoSet);

        for(SampleDataDto sampleDataDto : sampleDataDtoList2){

            /*
            * ---result---
            * SampleDataDto10
            * Content10
            * 10
            * */
            System.out.println(sampleDataDto.getTitle());
            System.out.println(sampleDataDto.getContent());
            System.out.println(sampleDataDto.getId());
        }


    }


}
