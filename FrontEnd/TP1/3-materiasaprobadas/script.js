const materiasAprobadas = [
    {
        nombre: "Algoritmos y Paradigmas",
        situacion: "Aprobado",
        profesor: "Viviana Rivas",
        nota: "9",
    },
    {
        nombre: "Algebra I",
        situacion: "Aprobado",
        profesor: "Ricardo Javier Zivec",
        nota: "10",
    },
    {
        nombre: "Inglés A1",
        situacion: "Aprobado",
        profesor: "Alvarez Carlos Ariel",
        nota: "7",
    },
    {
        nombre: "Formación Humanística I ",
        situacion: "Aprobado",
        profesor: "Jaqueline Guevara",
        nota: "9",
    },
    {
        nombre: "Desarrollo de Software",
        situacion: "Aprobado",
        profesor: "Tulio Ruesjas Martin",
        nota: "8",
    },
    {
        nombre: "Gestión de RRHH",
        situacion: "Aprobado",
        profesor: "Un tonto",
        nota: "6",
    },
    {
        nombre: "Bases de Datos",
        situacion: "Aprobado",
        profesor: "Tulio Ruesjas Martin",
        nota: "10",
    },
    {
        nombre: "Algebra II ",
        situacion: "Aprobado",
        profesor: "Ricardo Javier Zivec",
        nota: "6.25",
    },
    {
        nombre: "Seminario Informático I ",
        situacion: "Aprobado",
        profesor: "Florencia Nucci",
        nota: "10",
    },
];

let tableBody = document.getElementById('team-member-rows');

const itemsOnPage = 9;

const numberOfPages = Math.ceil(materiasAprobadas.length / itemsOnPage);

const start = (new URLSearchParams(window.location.search)).get('page') || 1;

const mappedRecords = materiasAprobadas
    .filter((_, i) =>(
        ((start - 1) * itemsOnPage) < i + 1) &&
        (i+1 <= start * itemsOnPage)
    )
    .map(
        (teamMember) => {
            return `
            <tr>
                <td class="team-member-profile">
                    <span class="profile-info">
                        <span class="profile-info__name">
                            ${teamMember.nombre}
                        </span>
                    </span>
                </td>
                <td>
                    <span class="status status--${teamMember.situacion}">
                        ${teamMember.situacion}
                    </span>
                </td>
                <td>${teamMember.profesor}</td>
                <td>${teamMember.nota}</td>
            </tr>`;
        });

tableBody.innerHTML = mappedRecords.join('');


